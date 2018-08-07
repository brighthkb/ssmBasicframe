package com.sczh.core.web.dto;

import java.util.List;

/** 列表数据格式（一般用于分页请求）  */

public class PagingResult<T>{
	private long total;
	private List<T> rows;
	private List<T> footer;//用于表格总计
	
	public PagingResult(long l, List<T> rows) {
		this.total = l;
		this.rows = rows;
	}
	
	public PagingResult(long total, List<T> rows, List<T> footer) {
		this(total, rows);
		this.footer = footer;
	}

	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public List<T> getFooter() {
		return footer;
	}
	public void setFooter(List<T> footer) {
		this.footer = footer;
	}	
}
