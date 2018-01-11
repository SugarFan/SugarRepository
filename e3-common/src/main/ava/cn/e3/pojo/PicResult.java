package cn.e3.pojo;

public class PicResult {
	/**
    "url" : "http://www.example.com/path/to/file.ext"
    "error" : 1,
    "message" : "错误信息"
	 */
	
	private String url;

	private int error;
	
	private String message;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
