package cn.com.mybatis.po;

import java.util.Date;
import java.util.List;

public class Batch {
	private int batch_id;
	private int cus_id;
	private String number;
	private Date createtime;
	private String note;
	private List<BatchDetail> batchDetailList;
	
	public List<BatchDetail> getBatchDetailList() {
		return batchDetailList;
	}
	public void setBatchDetailList(List<BatchDetail> batchDetailList) {
		this.batchDetailList = batchDetailList;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return getClass().getName()+"[batch_id=" + batch_id + ", cus_id=" + cus_id + ", number=" + number + ", createtime="
				+ createtime + ", note=" + note + "]";
	}
	
}
