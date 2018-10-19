package com.vns.controller;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.Utils;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.vns.VnsWeb3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] arg0){
        //
        List<Type> typeList = decodeFunctionInput("0xa9059cbb00000000000000000000000094e66e5a13c8ecbe37ed146b142d4568d0586b2d0000000000000000000000000000000000000000000000000000000000000001");
        System.out.println(typeList);
        System.out.println(typeList.get(0));
//        VnsWeb3j vnsWeb3j = VnsWeb3j.build(new HttpService("http://132.232.166.46:8585/"));
//        try {
//            BigInteger balance = vnsWeb3j.ethGetBalance("0x57bf28ced6d6eda32f8a44f5504fc0943dfd36d1", DefaultBlockParameterName.LATEST).send().getBalance();
//            System.out.println(balance);
//            System.out.println(toDecimal(18,balance));
//            System.out.println("11111111"+toDecimal(18,getTokenBalance(vnsWeb3j,"0xe62f55374d58c9086787c74c9f7226874707f077","0xe62f55374d58c9086787c74c9f7226874707f077")));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    /**
     * 查询代币余额
     */
    public static BigInteger getTokenBalance(VnsWeb3j web3j, String fromAddress, String contractAddress) {

        String methodName = "balanceOf";
        List<Type> inputParameters = new ArrayList<>();
        List<TypeReference<?>> outputParameters = new ArrayList<>();
        Address address = new Address(fromAddress);
        inputParameters.add(address);

        TypeReference<Uint256> typeReference = new TypeReference<Uint256>() {
        };
        outputParameters.add(typeReference);
        Function function = new Function(methodName, inputParameters, outputParameters);
        String data = FunctionEncoder.encode(function);
        Transaction transaction = Transaction.createEthCallTransaction(fromAddress, contractAddress, data);

        EthCall ethCall;
        BigInteger balanceValue = BigInteger.ZERO;
        try {
            ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();
            List<Type> results = FunctionReturnDecoder.decode(ethCall.getValue(), function.getOutputParameters());
            balanceValue = (BigInteger) results.get(0).getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balanceValue;
    }

    public static List<Type> decodeFunctionInput(String input) {
        List<Type> results = null;
//        if (input.length() < 128) {
//            return results;
//        }
        results = FunctionReturnDecoder.decode(input.substring(input.length()), Utils.convert(Arrays.asList(new TypeReference<Address>() {
        }, new TypeReference<Uint256>() {
        })));
        return results;
    }

    public static String toDecimal(int decimal,BigInteger integer){
//		String substring = str.substring(str.length() - decimal);
        StringBuffer sbf = new StringBuffer("1");
        for (int i = 0; i < decimal; i++) {
            sbf.append("0");
        }
        String balance = new BigDecimal(integer).divide(new BigDecimal(sbf.toString()), 18, BigDecimal.ROUND_DOWN).toPlainString();
        return balance;
    }
}
