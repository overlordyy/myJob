package com.vns.util;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public final static String address = "0x1C4749A6e7082aac17083029c9eb2DCe4045d912";
    /**
     * 获取两个时间之间的间隔(秒)
     */
    public static long getBetweenSeconds(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
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
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    public static Date getEndDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    /**
     * 取1天前0时0分0秒
     * @param current
     * @return
     */
    public static Date getYesterdayBeginDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DAY_OF_MONTH, -1); // 1天前
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**
     * 取1天前23时59分59秒
     * @param current
     * @return
     */
    public static Date getYesterdayEndDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DAY_OF_MONTH, -1); // 1天前
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    /**
     * 取N天前当前时间
     * @param current
     * @param nday
     * @return
     */
    public static Date getNdayAgoDate(Date current, int nday) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DAY_OF_MONTH, -nday); // N天前
        return c.getTime();
    }
    
    /**
     * 取N天前0时0分0秒
     * @param current
     * @return
     */
    public static Date getNdayAgoBeginDate(Date current, int nday) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DAY_OF_MONTH, -nday); // N天前
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**
     * 取N天前23时59分59秒
     * @param current
     * @return
     */
    public static Date getNdayAgoEndDate(Date current, int nday) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.DAY_OF_MONTH, -nday); // N天前
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    /**
     * 将日期的时期设置为0时0分0秒
     * @param date
     * @return
     */
    public static Date get0SecDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    /**
     * 获取两个日期之间的相隔天数
     * @param begin
     * @param end
     * @return
     */
    public static int differentDaysByMillisecond(Date begin,Date end) {
    	int days = (int) ((end.getTime() - begin.getTime()) / (1000*3600*24));
        return days;
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
    
    public static String formatDuring(long mss) {
		long days = mss / (1000 * 60 * 60 * 24);
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		return days + "天" + hours + "时" + minutes + "分"
				+ seconds + "秒";
	}

}
