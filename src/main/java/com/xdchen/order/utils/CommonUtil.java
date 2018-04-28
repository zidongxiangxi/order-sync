package com.xdchen.order.utils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CommonUtil {
	public static DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

	public static Hashtable ht = null;

	// select t.*, t.rowid from f_user_query t where t.kuaidicom like '%信丰%'
	// --update f_user_query set kuaidicom='xinfengwuliu' where kuaidicom like
	// '%信丰%'
	static {
		if (ht == null) {
			ht = new Hashtable();
			ht.put("中通快递", "zhongtong");
			ht.put("申通快递", "shentong");
			ht.put("韵达快递", "yunda");
			ht.put("天天", "tiantian");
			ht.put("韵达快运", "yunda");
			ht.put("海航天天快递", "tiantian");
			ht.put("顺丰速运", "shunfeng");
			ht.put("申通E物流", "shentong");
			ht.put("微特派快递有限公司", "weitepai"); // 微特派快递有限公司
			ht.put("如风达配送", "rufengda");// 如风达配送
			ht.put("凡客", "rufengda");
			ht.put("海航天天", "tiantian");
			ht.put("广州顺丰速运有限公司", "shunfeng"); // 广州顺丰速运有限公司
			ht.put("速尔", "suer"); // 速尔
			ht.put("佳吉", "jiajiwuliu");
			ht.put("佳吉物流", "jiajiwuliu");
			ht.put("佳吉快递", "jiajiwuliu");
			ht.put("佳吉货运", "jiajiwuliu");
			ht.put("山东海红", "haihongwangsong");
			ht.put("邮政国内小包", "youzhengguonei"); // 邮政国内小包
			ht.put("信丰", "xinfengwuliu"); // 信丰
			ht.put("信丰快递", "xinfengwuliu");// 信丰快递
			ht.put("华宇", "tiandihuayu"); // 华宇
			ht.put("昊盛快递", "haoshengwuliu"); // 昊盛快递
			ht.put("龙邦速递", "longbanwuliu"); // 龙邦速递
			ht.put("速尔快递", "suer");// 速尔快递
			ht.put("申通", "shentong");// 申通
			ht.put("中通物流", "zhongtong");// 中通物流
			ht.put("圆通快递", "yuantong");// 圆通快递
			ht.put("圆通", "yuantong");// 圆通
			ht.put("汇通", "huitongkuaidi");// 汇通
			ht.put("韵达", "yunda");// 韵达
			ht.put("韵达物流", "yunda");// 韵达物流
			ht.put("速尔物流", "suer");// 速尔物流
			ht.put("天天物流", "tiantian");// 天天物流
			ht.put("华宇物流", "tiandihuayu");// 华宇物流
			ht.put("天地华宇物流", "tiandihuayu");
			ht.put("ems经济快递", "ems");
			ht.put("EMS经济快递", "ems");
			ht.put("DHL德国", "dhlde");
			ht.put("优速", "youshuwuliu");// 优速
			ht.put("优速快递", "youshuwuliu");// 优速
			ht.put("港中能达", "ganzhongnengda"); //港中能达
			ht.put("中通速递", "zhongtong"); //港中能达
			ht.put("中通", "zhongtong");
			ht.put("圆通速递", "yuantong"); //港中能达
			ht.put("汇通快运", "huitongkuaidi"); //港中能达
			ht.put("百世快递", "huitongkuaidi");
			ht.put("韵达速递", "yunda");
			ht.put("天天快递", "tiantian");
			ht.put("百世汇通", "huitongkuaidi");
			ht.put("国通快递", "guotongkuaidi");
			ht.put("国通", "guotongkuaidi");
			ht.put("凡客旗下快递", "vancl");
			ht.put("圆通上海良仪快递", "yuantong");
			ht.put("全峰快递", "quanfengkuaidi");
			ht.put("增益速递", "zengyisudi");
			ht.put("宅急送", "zhaijisong");
			ht.put("飞远配送", "feiyuanvipshop");
			ht.put("快捷", "kuaijiesudi");
			ht.put("快捷速递", "kuaijiesudi");
			ht.put("日日顺物流", "rrs");
			ht.put("百世快运", "baishiwuliu");
			ht.put("澳邮中国快运", "auexpress");
			ht.put("成都东骏快捷物流有限公司", "dongjun");
			ht.put("新顺丰国际速递", "nsf");
			ht.put("晟邦物流", "nanjingshengbang");
			ht.put("秦远国际物流", "qinyuan");
			ht.put("黄马甲快递", "huangmajia");
			ht.put("epost", "youzhengguoji");
			ht.put("富腾达快递", "ftd");
			ht.put("程光快递", "flyway");
			ht.put("FOX国际快递", "fox");
			ht.put("中华邮政", "postserv");
			ht.put("品骏快递", "pjbest");
			ht.put("四川邮政经济快递", "ems");
			ht.put("晟邦物流-天猫小家电", "nanjingshengbang");
			ht.put("晟邦-快消", "nanjingshengbang");
			ht.put("苏宁快递", "suning");
			ht.put("远成快运", "ycgky");
			ht.put("远成物流", "yuanchengwuliu");
		}
	}

	public static String getCompanyCode(String key) {
		if (key == null) {
			return "";
		}

		String result = (ht != null && ht.get(key) != null) ? ht.get(key)
				.toString() : key;

		return result;
	}

	public static boolean containsCompany(String key) {
		if (key == null) {
			return false;
		}
		return (ht != null && ht.get(key) != null) ? true : false;
	}

	public static Date getDate(String dateStr) {
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getDate1(String dateStr) {
		try {
			return dateFormat1.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String parseDate(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 将输入的日期格式化为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return date
	 */
	public static Date convertDate(Date date) {
		return getDate(parseDate(date));
	}

	public static String getResourcePath(Class clazz, String fileName) {
		return clazz.getClassLoader().getResource(fileName).getPath();
	}

	public static boolean isNull(String s) {
		return s == null || "".equals(s) ? true : false;
	}

	public static String getString(String s) {
		return s == null ? "" : s;
	}

	@SuppressWarnings("unused")
	public static boolean isLong(String s) {
		if (isNull(s)) {
			return false;
		}
		try {
			Long l = Long.parseLong(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String convertMoney(String price, String discounttype,
                                      String discountvalue) {
		BigDecimal d1 = new BigDecimal(price);
		if (discounttype.equals("PRICE")) {
			BigDecimal d2 = new BigDecimal(discountvalue);
			return d1.subtract(d2).setScale(2, BigDecimal.ROUND_HALF_UP)
					.toString();
		} else {
			BigDecimal d2 = new BigDecimal(discountvalue);
			return d1.multiply(d2.multiply(new BigDecimal("0.1")))
					.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}
	}

	public static String htmlEncode(String s) {
		StringBuffer stringbuffer = new StringBuffer();
		int j = s.length();
		for (int i = 0; i < j; i++) {
			char c = s.charAt(i);
			switch (c) {
			case 60:
				stringbuffer.append("&lt;");
				break;
			case 62:
				stringbuffer.append("&gt;");
				break;
			case 38:
				stringbuffer.append("&amp;");
				break;
			case 34:
				stringbuffer.append("&quot;");
				break;
			case 169:
				stringbuffer.append("&copy;");
				break;
			case 174:
				stringbuffer.append("&reg;");
				break;
			case 165:
				stringbuffer.append("&yen;");
				break;
			case 8364:
				stringbuffer.append("&euro;");
				break;
			case 8482:
				stringbuffer.append("&#153;");
				break;
			case 13:
				if (i < j - 1 && s.charAt(i + 1) == 10) {
					stringbuffer.append("<br>");
					i++;
				}
				break;
			case 32:
				if (i < j - 1 && s.charAt(i + 1) == ' ') {
					stringbuffer.append(" &nbsp;");
					i++;
					break;
				}
			default:
				stringbuffer.append(c);
				break;
			}
		}
		return new String(stringbuffer.toString());
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static boolean checkForExpiresIn(long expires_in) {
		long now = System.currentTimeMillis();
		if (now - expires_in >= 0) {
			return false;
		} else {
			return true;
		}
	}

	public static String sCharFilter(String result) {
		result = result.replaceAll("<", " ").replaceAll(">", " ");
		return result;
	}

	public static Date dateCalculate(Date now, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, count);
		return calendar.getTime();
	}

	public static Date monthCalculate(Date now, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, count);
		return calendar.getTime();
	}
}
