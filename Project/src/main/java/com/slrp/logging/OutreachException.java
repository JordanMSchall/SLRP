package com.slrp.logging;

public class OutreachException extends Exception {
	
	private static final long serialVersionUID = 7310609932496155912L;

	private final ErrorCode code;

	public OutreachException(ErrorCode code) {
		super();
		this.code = code;
	}

	public OutreachException(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public OutreachException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public OutreachException(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}

	public ErrorCode getCode() {
		return this.code;
	}
}
