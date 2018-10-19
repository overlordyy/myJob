package com.vns.util;

/**
 * 常量
 * @author Lvp
 *
 */
public interface Constants {

	/**
	 * 字典路径
	 */
	public static class DictionaryPath {

		public static final long PREDUG = Long.parseLong("3860977695");
		/**
		 * VNS生日
		 */
		public static final String VNS_BIRTHDAY = "VNS_BIRTHDAY"; // VNS生日
		/**
		 * VNS预挖量
		 */
		public static final String PRE_VNS_COIN_NUMBER = "PRE_VNS_COIN_NUMBER"; // VNS预挖量
		/**
		 * 创世区块Hash
		 */
		public static final String CREATION_BLOCK_HASH = "CREATION_BLOCK_HASH"; // 创世区块Hash
		/**
		 * 创世区块生成时间
		 */
		public static final String CREATION_BLOCK_TIME = "CREATION_BLOCK_TIME"; // 创世区块生成时间
		/**
		 * 区块链首次交易时间
		 */
		public static final String FIRST_TRANSACTIONS_TIME = "FIRST_TRANSACTIONS_TIME"; // 区块链首次交易时间
		/**
		 * 矿工奖励（挖块奖励）
		 */
		public static final String MINER_REWARD = "MINER_REWARD"; // 矿工奖励（挖块奖励）
	}
	
	/**
	 * 区块相关
	 */
	public static class Block {
		/**
		 * 叔块标识：是
		 */
		public static final int IS_UNCLE_BLOCK_YES = 1; 
		/**
		 * 叔块标识：否
		 */
		public static final int IS_UNCLE_BLOCK_NO = 0; 
		/**
		 * 出块时间：15S
		 */
		public static final int BLOCK_PRODUCE_TIME = 15;
	}
	
	/**
	 * 交易相关
	 */
	public static class Trasaction {
		/**
		 * 18位，用来转换VNS和Wei
		 */
		public static final double WEI_4_VNS_UNIT = 1000000000000000000d; 
	}
	
	/**
	 * 日期时间 相关
	 */
	public static class DateAndTime {
		/**
		 * 标准时间格式
		 */
		public static final String NORMAL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; 
		/**
		 * 一天的秒数 
		 */
		public static final int SECOND_OF_DAY = 86400;
		/**
		 * 两周前，14
		 */
		public static final int TWO_WEEK_OF_DAY = 14;
	}
}
