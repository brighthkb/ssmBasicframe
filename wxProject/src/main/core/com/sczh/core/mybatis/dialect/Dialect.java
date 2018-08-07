package com.sczh.core.mybatis.dialect;

public abstract class Dialect {
	public static enum Type {
		MYSQL, ORACLE, MSSQL, DB2, PGSQL
	}

	/**
	 * @param sql
	 * @param offset
	 * @param limit
	 * @return
	 */
	public abstract String getLimitString(String sql, int offset, int limit);
}
