package com.javaassignment.response;

public class ListDataResponse {
	private Integer statuscode;
	private String message;
	private Boolean status;
	private int recordCount;
	private int totalPageCount;
	private Object data;

	public ListDataResponse(Integer statuscode, Boolean status, String message, int recordCount,
			int totalPageCount, Object data) {
		this.statuscode = statuscode;
		this.message = message;
		this.status = status;
		this.recordCount = recordCount;
		this.totalPageCount = totalPageCount;
		this.data = data;
	}

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
