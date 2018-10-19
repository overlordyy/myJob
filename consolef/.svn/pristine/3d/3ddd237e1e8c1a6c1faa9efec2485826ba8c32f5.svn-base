package com.vns.controller;

public class InitSql {

	public static void main(String[] args) {
		String sqlStr = "insert into t_transaction ( Hash, BlockHash, BlockNumber, Creates, From, To, Value, Gas, GasPrice, Input, Nonce, PublicKey, R, Raw, S, TransactionIndex, V, TransactionTime, TransactionType, ContractAddress, TransactionPoundage )values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
		String argStr = "0xbe892e8c7cd67456f38316f6fcdc0966757ba89bd6f777f512f7c3d69b3f3749(String), 0xf10e4cfbc3cd2ea57ee8732cceb9237c550414499bce9ed009729a92ffbd597a(String), 9110(Long), null, 0x1a2c615960142bef560c37f452fd409cae7aff05(String), 0xdc04519f6227c9856c25f28d0203d7a7e2e5a74a(String), 1230000000000000000(String), 90000.0(Float), 1.7999999E10(Float), 0x(String), 0(String), null, 0x25e0cf1a770f7e23ef91989f6eb32812e435720bc37807ee1c014c56f6b85762(String), null, 0xec0e82d806708f15fb5c2114c9a0eba78b8d2be5dfb0c6b72b945fc13771fcb(String), 0(String), 4072(Integer),  0(Integer), null";
		String[] argArr = argStr.split(",");
		for (String arg : argArr) {
			try {
				arg = arg.trim();
				String replacement = null;
				if("null".equals(arg)){
					replacement="";
				}else if(arg.contains("(Integer)")){
					arg = arg.replaceAll("\\(Integer\\)","");
					replacement = arg;
				}else if(arg.contains("(Float)")){
					arg = arg.replaceAll("\\(Float\\)","");
					replacement = arg;
				}else if(arg.contains("(Long)")){
					arg = arg.replaceAll("\\(Long\\)","");
					replacement = arg;
				}else if(arg.contains("(String)")){
					arg = arg.replaceAll("\\(String\\)","");
					replacement = "'"+arg+"'";
				}
				sqlStr = sqlStr.replaceFirst("\\?", replacement);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(sqlStr);
		}
	}
}
