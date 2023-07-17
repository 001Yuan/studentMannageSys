package com.qf.domain;
/**
 * 分页类
 * @author wgy
 *
 */

import java.util.List;

public class PageBean<T> {
	private int pageNum;//当前页码
	private int pageSize;//页大小
	private long totalCount;//总的数据个数
	private int totalPage;//总的页数
	
	private List<T> data;//当前也的数据

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	

	public PageBean() {
		// TODO Auto-generated constructor stub
	}

	public PageBean(int pageNum, int pageSize, long totalCount,List<T> data) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.data = data;
		
		//计算总页数    100  /10 =10    101 /10 =11
		if(totalCount%pageSize==0) {
			totalPage=(int) (totalCount/pageSize);
		}else {
			totalPage=(int) (totalCount/pageSize)+1;
		}
	
		
	}

	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", data=" + data + "]";
	}

	
	
}
