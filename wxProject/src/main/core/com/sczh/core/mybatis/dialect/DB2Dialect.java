package com.sczh.core.mybatis.dialect;

public class DB2Dialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		//将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
		sql = sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
		sql = sql.trim();
		if(sql.endsWith(";"))
			sql = sql.substring(0, sql.length()-1);
		
		StringBuffer sb = new StringBuffer(sql.length()+98);
		sb.append("select * from ( select a.*, ROW_NUMBER() OVER() AS rownum_ from ( ");
		sb.append(sql);
		sb.append(" ) as a ) where rownum_ > "+offset+" and rownum_ <= "+(offset + limit));
		
		return sb.toString();
	}

}
