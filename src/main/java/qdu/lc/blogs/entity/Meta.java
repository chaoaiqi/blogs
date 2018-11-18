package qdu.lc.blogs.entity;

/**
 * 请求元数据
 * 
 * @author Michael
 *
 */
public class Meta {

	private boolean success;
	private String message;

	public Meta(boolean success) {
		this.success = success;
	}

	public Meta(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
