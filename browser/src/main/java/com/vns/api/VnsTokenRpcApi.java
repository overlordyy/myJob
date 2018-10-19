package com.vns.api;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.ens.contracts.generated.ENS.TransferEventResponse;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

public class VnsTokenRpcApi{

	public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

	public static EthSendTransaction deploy(String signedTransactionData) throws IOException {
        return VnsRpcApi.sendRawTransaction(signedTransactionData);
    }

    public static Utf8String name(String address, String contractAddress) throws IOException {
        Function function = new Function("name",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }));
        return executeCallSingleValueReturn(address, contractAddress, function);
    }

    public static Uint256 totalSupply(String address, String contractAddress) throws IOException {
        Function function = new Function("totalSupply",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeCallSingleValueReturn(address, contractAddress, function);
    }

    public static Uint8 decimals(String address, String contractAddress) throws IOException {
        Function function = new Function("decimals",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {
                }));
        return executeCallSingleValueReturn(address, contractAddress, function);
    }

    public static Utf8String symbol(String address, String contractAddress) throws IOException {
        Function function = new Function("symbol",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }));
        return executeCallSingleValueReturn(address, contractAddress, function);
    }

    public static Uint256 balance(String address, String contractAddress) throws IOException {
        Function function = new Function("balanceOf",
                Arrays.<Type>asList(new Address(address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeCallSingleValueReturn(address, contractAddress, function);
    }

    private static List<Type> executeCall(String address, String contractAddress, Function function) throws IOException {
        String encodedFunction = FunctionEncoder.encode(function);
        String value = VnsRpcApi.call(Transaction.createEthCallTransaction(address, contractAddress, encodedFunction), DefaultBlockParameterName.LATEST);
        return FunctionReturnDecoder.decode(value, function.getOutputParameters());
    }

    private static <T extends Type> T executeCallSingleValueReturn(String address, String contractAddress, Function function) throws IOException {
        List<Type> values = executeCall(address, contractAddress, function);
        return !values.isEmpty() ? (T) values.get(0) : null;
    }
    
    private static List<EventValues> extractEventParameters(
            Event event, TransactionReceipt transactionReceipt) {
        return transactionReceipt.getLogs().stream()
                .map(log -> extractEventParameters(event, log))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    
    protected static EventValues extractEventParameters(Event event, Log log) {
        return staticExtractEventParameters(event, log);
    }
    
    public static EventValues staticExtractEventParameters(
            Event event, Log log) {

        List<String> topics = log.getTopics();
        String encodedEventSignature = EventEncoder.encode(event);
        if (!topics.get(0).equals(encodedEventSignature)) {
            return null;
        }

        List<Type> indexedValues = new ArrayList<>();
        List<Type> nonIndexedValues = FunctionReturnDecoder.decode(
                log.getData(), event.getNonIndexedParameters());

        List<TypeReference<Type>> indexedParameters = event.getIndexedParameters();
        for (int i = 0; i < indexedParameters.size(); i++) {
            Type value = FunctionReturnDecoder.decodeIndexedValue(
                    topics.get(i + 1), indexedParameters.get(i));
            indexedValues.add(value);
        }
        return new EventValues(indexedValues, nonIndexedValues);
    }
    
    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _value;
    }
}
