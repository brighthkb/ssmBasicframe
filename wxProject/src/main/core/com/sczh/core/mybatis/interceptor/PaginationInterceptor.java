package com.sczh.core.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.sczh.core.exception.SystemException;
import com.sczh.core.mybatis.dialect.Dialect;
import com.sczh.core.mybatis.dialect.MSSqlDialect;
import com.sczh.core.mybatis.dialect.MySql5Dialect;
import com.sczh.core.mybatis.dialect.OracleDialect;

@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args={Connection.class}))
public class PaginationInterceptor implements Interceptor {
	private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
	public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private String dialect;
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object object = null;
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaObject = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		RowBounds rowBounds = (RowBounds) metaObject.getValue("delegate.rowBounds");
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		
		String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");
		
		if(log.isDebugEnabled()){
			log.debug("SQL语句:"+originalSql);
		}
		
		//判断rowBounds是否为默认设置，是则执行默认操作
		if(rowBounds == null || rowBounds == RowBounds.DEFAULT){
			try{
				object = invocation.proceed();
			}catch (Exception e) {
				throw new SystemException("Paging failure", e);
			}
			return object;
		}
		
		Dialect.Type databaseType = null;
		Configuration configuration = (Configuration) mappedStatement.getConfiguration();//metaObject.getValue("delegate.configuration");
		try{
			//数据库方言
			//databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
			databaseType = Dialect.Type.valueOf(dialect.toUpperCase());
		}catch (Exception e) {
			throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + configuration.getVariables().getProperty("dialect"));
		}
		
		Dialect dialect = null;
		switch (databaseType) {
		case ORACLE:
			dialect = new OracleDialect();
			break;
		case MYSQL:
			dialect = new MySql5Dialect();
			break;
		case MSSQL:
			dialect = new MSSqlDialect();
			break;
		case DB2:
			dialect = new MSSqlDialect();
			break;
		case PGSQL:
			dialect = new MSSqlDialect();
			break;
		default:
			break;
		}
		
		if(dialect == null){
			throw new NullPointerException("Dialect is NULL!");
		}
		
		metaObject.setValue("delegate.boundSql.sql",  dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
		metaObject.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET );
		metaObject.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT );
		
		if(log.isDebugEnabled())
			log.debug("生成分页SQL : " + boundSql.getSql());
		
		try{
			object = invocation.proceed();
		}catch (Exception e) {
			throw new SystemException("Paging failure", e);
		}
		return object;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		//dialect = properties.getProperty("dialect", "mysql");
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

}
