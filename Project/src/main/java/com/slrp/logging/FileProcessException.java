package com.slrp.logging;

public class FileProcessException extends Exception {

	private static final long serialVersionUID = 7310609932496155932L;
	
	private final ErrorCode code;

	public FileProcessException(ErrorCode code) {
		super();
		this.code = code;
	}
	
	public FileProcessException(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}

	public FileProcessException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	public FileProcessException(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}
	
}
