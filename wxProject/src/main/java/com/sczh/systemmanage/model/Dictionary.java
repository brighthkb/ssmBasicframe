package com.sczh.systemmanage.model;

import java.io.Serializable;
import java.util.Date;

public class Dictionary implements Serializable {
    private String id;

    private String superId;

    private String datadicval;

    private String name;

    private String expr;
    
    private Integer taxis;

    private String strtus;

    private Date createTime;

    private Date updateDate;

    private String remark;
    
    private java.lang.String allName;//类型全名

    private static final long serialVersionUID = 1L;

   

    public Dictionary(String id, String superId, String datadicval,
			String name, String expr, Integer taxis, String strtus,
			Date createTime, Date updateDate, String remark) {
		super();
		this.id = id;
		this.superId = superId;
		this.datadicval = datadicval;
		this.name = name;
		this.expr = expr;
		this.taxis = taxis;
		this.strtus = strtus;
		this.createTime = createTime;
		this.updateDate = updateDate;
		this.remark = remark;
	}

	public Dictionary() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId == null ? null : superId.trim();
    }

    public String getDatadicval() {
        return datadicval;
    }

    public void setDatadicval(String datadicval) {
        this.datadicval = datadicval == null ? null : datadicval.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr == null ? null : expr.trim();
    }
    
    public Integer getTaxis() {
		return taxis;
	}

	public void setTaxis(Integer taxis) {
		this.taxis = taxis;
	}

	public String getStrtus() {
        return strtus;
    }

    public void setStrtus(String strtus) {
        this.strtus = strtus == null ? null : strtus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public java.lang.String getAllName() {
		return allName;
	}

	public void setAllName(java.lang.String allName) {
		this.allName = allName;
	}
    
    
}