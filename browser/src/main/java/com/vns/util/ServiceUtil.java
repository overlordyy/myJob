package com.vns.util;

import java.math.BigDecimal;

import com.vns.vo.HomeBlock;

/**
 * 业务工具类
 * @author Lvp
 *
 */
public class ServiceUtil {

	/**
	 * 算力转换：H转成GH，并保留3位小数
	 * @param difficulty H转成MH，并保留3位小数
	 * @return
	 */
	public static double difficultyH4GH(long difficulty) {
		double difficulty4GH = 0.0d;
		// 难度单位调整
		if (0L != difficulty) {
			// 转换成单位M， 规则：1 MHash/s = 1000 KHash/s    1 KHash/s = 1000 Hash/s
			double diff = difficulty / 1000d / 1000d / 1000d;
			// 四舍五入取小数点3位
			difficulty4GH =new BigDecimal(diff).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return difficulty4GH;
	}
	
	/**
	 * 算力转换：H转成MH，并保留3位小数
	 * @param difficulty H转成MH，并保留3位小数
	 * @return
	 */
	public static double difficultyH4MH(long difficulty) {
		double difficulty4MH = 0.0d;
		// 难度单位调整
		if (0L != difficulty) {
			// 转换成单位M， 规则：1 MHash/s = 1000 KHash/s    1 KHash/s = 1000 Hash/s
			double diff = difficulty / 1000d / 1000d;
			// 四舍五入取小数点3位
			difficulty4MH =new BigDecimal(diff).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return difficulty4MH;
	}
	
	/**
	 * 算力转换：H转成MH，并保留3位小数
	 * @param difficulty
	 * @return
	 */
	public static double difficultyH4MH(double difficulty) {
		double difficulty4MH = 0.0d;
		// 转换成单位M， 规则：1 MHash/s = 1000 KHash/s    1 KHash/s = 1000 Hash/s
		double diff = difficulty / 1000d / 1000d;
		// 四舍五入取小数点3位
		difficulty4MH =new BigDecimal(diff).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		return difficulty4MH;
	}
	
	/**
	 * 算力转换：H转成KH，并保留3位小数
	 * @param difficulty H转成KH，并保留3位小数
	 * @return
	 */
	public static double difficultyH4KH(long difficulty) {
		double difficulty4KH = 0.0d;
		// 难度单位调整
		if (0L != difficulty) {
			// 转换成单位M， 规则：1 MHash/s = 1000 KHash/s    1 KHash/s = 1000 Hash/s
			double diff = difficulty / 1000d;
			// 四舍五入取小数点3位
			difficulty4KH =new BigDecimal(diff).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return difficulty4KH;
	}
	
	/**
	 * 算力转换：H转成KH，并保留3位小数
	 * @param difficulty H转成KH，并保留3位小数
	 * @return
	 */
	public static double unitH4KH(double difficulty) {
		double difficulty4KH = 0.0d;
		// 转换成单位M， 规则：1 MHash/s = 1000 KHash/s    1 KHash/s = 1000 Hash/s
		double diff = difficulty / 1000d;
		// 四舍五入取小数点3位
		difficulty4KH =new BigDecimal(diff).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		return difficulty4KH;
	}
	
	/**
	 * 将原始网络难度 和 全网算力转换一下单位
	 * @param hb
	 * @return
	 */
	public static HomeBlock formatDifficultyAndHashRate(HomeBlock hb) {
		// 难度单位调整
		long difficulty = null==hb.getDifficulty() ? 0 : Long.parseLong(hb.getDifficulty());
		if (0L != difficulty) {
			// 四舍五入取小数点3位
			double difficulty4M = difficultyH4MH(difficulty);
			// 重新设置难度值
			hb.setDifficulty(String.valueOf(difficulty4M));
			
			// 出块时间
			int blockProduceTime = hb.getBlockProduceTime();
			double hashRate4M =new BigDecimal(hb.getHashRate()).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
			hb.setHashRate(hashRate4M);
			//计算全网算力
//			if (0 != blockProduceTime) {
//				// 计算算力，公式：难度/出块时间
//				double hashRate = difficulty / 1000d / blockProduceTime;
//				double hashRate4M =new BigDecimal(hashRate).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
//				hb.setHashRate(hashRate4M);
//			}
		}
		return hb;
	}
}
