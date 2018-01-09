package cn.e3.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIPageBean implements Serializable{
	private Long totle;
	
	private List<?> rows;

	public Long getTotle() {
		return totle;
	}

	public void setTotle(Long totle) {
		this.totle = totle;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
