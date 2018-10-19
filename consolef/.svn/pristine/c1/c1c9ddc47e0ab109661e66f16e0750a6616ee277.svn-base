package com.vns.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

public class VnsTokenRpcApi {

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
}
