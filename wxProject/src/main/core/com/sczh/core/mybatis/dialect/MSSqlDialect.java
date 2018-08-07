package com.sczh.core.mybatis.dialect;

public class MSSqlDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		//将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
		sql = sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
		sql = sql.trim();
		if(sql.endsWith(";"))
			sql = sql.substring(0, sql.length()-1);
		
		sql = sql.toUpperCase();
		sql = sql.replaceFirst("SELECT", "SELECT TOP "+(offset+limit-1));
		
		StringBuffer sb = new StringBuffer();
		sb.append("select t.* from (select top "+offset);
		sb.append(" * from ("+sql);
		sb.append(") t1)");
		return sb.toString();
	}
}
