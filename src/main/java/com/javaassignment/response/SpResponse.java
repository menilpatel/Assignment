package com.javaassignment.response;

import java.util.List;

public class SpResponse {
	int RecordCount;
	int TotalPageCount;
	List list;

	public int getRecordCount() {
		return RecordCount;
	}

	public void setRecordCount(int recordCount) {
		RecordCount = recordCount;
	}

	public int getTotalPageCount() {
		return TotalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		TotalPageCount = totalPageCount;
	}

	public List getlist() {
		return list;
	}

	public void setlist(List list) {
		this.list = list;
	}

}
