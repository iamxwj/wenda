package com.wd.data;

public class Message {

	private Boolean result;
	
	private String count;
	
	private Object core;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Object getCore() {
		return core;
	}

	public void setCore(Object core) {
		this.core = core;
	}

	@Override
	public String toString() {
		return "Message [result=" + result + ", count=" + count + ", core=" + core + "]";
	}


	
}
