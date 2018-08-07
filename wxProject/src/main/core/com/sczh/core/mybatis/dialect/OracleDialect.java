package com.sczh.core.mybatis.dialect;

public class OracleDialect extends Dialect {
	private final static String FOR_UPDATE = " for update";
	private final static int FOR_UPDATE_LEN = FOR_UPDATE.length();

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		//将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
		sql = sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
		
		sql = sql.trim();
		boolean isForUpdate = false;
		int sqlLen = sql.length();
		
		if(sql.endsWith(";"))
			sql = sql.substring(0, sql.length()-1);
		
		if((sql.toLowerCase()).endsWith(FOR_UPDATE)){
			sqlLen -= FOR_UPDATE_LEN;
			sql = sql.substring(0, sqlLen);
			isForUpdate = true;
		}
		
		StringBuffer sb = new StringBuffer(sqlLen+98);
		sb.append("select * from ( select a.*, rownum rownum_ from ( ");
		sb.append(sql);
		//sb.append(" ) a ) where rownum_ BETWEEN "+offset+" and "+(offset + limit));
		sb.append(" ) a ) where rownum_ > "+offset+" and rownum_ <= "+(offset + limit));
		
		if(isForUpdate)
			sb.append(FOR_UPDATE);
		
		return sb.toString();
	}

}
