package com.sczh.core.web.dto;


/** 分页请求参数封装   */

public class Paging {
	private int page=1;//当前页码
	private int rows=20;//一页显示行数
	private int startRowNo;//SQL分页参数处理：第几行开始
	private int endRowNo=20;//SQL分页参数处理：第几行结束
	
	public Paging() {
	}
	
	public Paging(int page, int rows) {
		this.page = page;
		this.rows = rows;
		this.startRowNo = (this.rows*(this.page-1));
		this.endRowNo = this.rows;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		this.startRowNo = (this.rows*(this.page-1));
		this.endRowNo = this.rows;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
		this.startRowNo = (this.rows*(this.page-1));
		this.endRowNo = this.rows;
	}
	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
	public int getEndRowNo() {
		return endRowNo;
	}
	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}
}
