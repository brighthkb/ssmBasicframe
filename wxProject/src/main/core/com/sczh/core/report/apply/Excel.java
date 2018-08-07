package com.sczh.core.report.apply;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 导出EXCEL配置
 */
@XStreamAlias("excel")
public class Excel {
	@XStreamAsAttribute
	private String id;
	@XStreamAsAttribute
	private String title;
	@XStreamImplicit
	private List<Sheet> sheets = new ArrayList<Sheet>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Sheet> getSheets() {
		return sheets;
	}
	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}

	/**
	 * 导出表单配置
	 */
	@XStreamAlias("sheet")
	public static class Sheet {
		@XStreamAsAttribute
		private String title;
		@XStreamImplicit
		private List<Column> columns = new ArrayList<Column>();

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public List<Column> getColumns() {
			return columns;
		}
		public void setColumns(List<Column> columns) {
			this.columns = columns;
		}

		/**
		 * 导出列配置
		 */
		@XStreamAlias("column")
		public static class Column {
			@XStreamAsAttribute
			private String title;
			@XStreamAsAttribute
			private String fieldName;
			@XStreamAsAttribute
			private Integer width;
			@XStreamAsAttribute
			private String align;
			@XStreamAsAttribute
			private String formatMethodName;
			@XStreamImplicit
			private List<Column> children = new ArrayList<Column>();
			
			/** 判断是否是复合表头 */
			public boolean isComplexColumn() {
				return children != null && !children.isEmpty();
			}

			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getFieldName() {
				return fieldName;
			}
			public void setFieldName(String fieldName) {
				this.fieldName = fieldName;
			}
			public Integer getWidth() {
				return width;
			}
			public void setWidth(Integer width) {
				this.width = width;
			}
			public String getAlign() {
				return align;
			}
			public void setAlign(String align) {
				this.align = align;
			}
			public String getFormatMethodName() {
				return formatMethodName;
			}
			public void setFormatMethodName(String formatMethodName) {
				this.formatMethodName = formatMethodName;
			}
			public List<Column> getChildren() {
				return children;
			}
			public void setChildren(List<Column> children) {
				this.children = children;
			}
		}
	}
}