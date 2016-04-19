

package com.gsu.pos.util;


import java.text.SimpleDateFormat;



public class DateConverter {

	public static java.sql.Date convertToSql (final java.util.Date today) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = fmt.format(today);
		java.sql.Date sqlDate = java.sql.Date.valueOf(new String(todayStr));
		return sqlDate;
	}
	public static void main (final String[] args) {
	}
}
