package com.vns.util;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.vns.vo.BlockInfo;

public class DateUtil {
	public final static String address = "0x1C4749A6e7082aac17083029c9eb2DCe4045d912";
    /**
     * 获取两个时间之间的间隔(秒)
     */
    public static long getBetweenSeconds(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }
    /**
     * 叔块奖励 = ( 叔块高度 + 8 - 包含叔块的区块的高度 ) * 普通区块奖励 / 8
     * @param uncleNumber
     * @return
     */
    public static float uncleReward(List<BlockInfo> uncleBlock,long blockNumber){
    	if(uncleBlock.size()==0){
    		return 0;
    	}
    	float uncleR = 0;
    	for (BlockInfo blockInfo : uncleBlock) {
    		blockInfo.setMinerReward((blockInfo.getBlockNumber()+8-blockNumber)*209/8);
    		uncleR = uncleR+(blockInfo.getBlockNumber()+8-blockNumber)*209/8;
		}
    	return uncleR;
    }
    
    /**
     * 叔块奖励 = ( 叔块高度 + 8 - 包含叔块的区块的高度 ) * 普通区块奖励 / 8
     * @param uncleNumber
     * @return
     */
    public static float uncleRewardInfo(BlockInfo uncleBlock,long blockNumber){
    	float uncleR = (uncleBlock.getBlockNumber()+8-blockNumber)*209/8;
    	return uncleR;
    }
    
    /**
     * 引用叔块奖励
     * 1/32*普通奖励*uncle_count  (0 ≤ uncle_count ≤ 2)
     * @return
     */
    public static float refUncleReward(int uncleCount){
    	if(uncleCount==0){
    		return 0;
    	}
    	float refUncleR = 1/32*209*uncleCount;
    	return refUncleR;
    }
    
    /**
     * 计算区块总手续费
     * @param gasPrices
     * @return
     */
    public static float blockPoundage(List<Float> gasPrices){
    	if(gasPrices.size()==0){
    		return 0;
    	}
    	float bp = 0;
    	for (Float f : gasPrices) {
			bp = bp+f;
		}
    	return bp;
    }
    
    private DateUtil() {
    }

    /*字母  日期或时间元素  表示  示例
    G  Era 标志符  Text  AD
    y  年  Year  1996; 96
    M  年中的月份  Month July; Jul; 07
    w  年中的周数  Number  27
    W  月份中的周数  Number  2
    D  年中的天数  Number  189
    d  月份中的天数  Number  10
    F  月份中的星期  Number  2
    E  星期中的天数  Text  Tuesday; Tue
    a  Am/pm 标记  Text  PM
    H  一天中的小时数（0-23）  Number  0
    k  一天中的小时数（1-24）  Number  24
    K  am/pm 中的小时数（0-11）  Number  0
    h  am/pm 中的小时数（1-12）  Number  12
    m  小时中的分钟数  Number  30
    s  分钟中的秒数  Number  55
    S  毫秒数  Number  978
    z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00
    Z  时区  RFC 822 time zone  -0800*/

    public static Date getBeginDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c.getTime();
    }
    public static Date getEndDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        return c.getTime();
    }

}