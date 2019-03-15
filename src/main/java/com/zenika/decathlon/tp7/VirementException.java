package com.zenika.decathlon.tp7;

public class VirementException extends RuntimeException {

	public VirementException() {
	}

	public VirementException(String message) {
		super(message);
	}

	public VirementException(Throwable cause) {
		super(cause);
	}

	public VirementException(String message, Throwable cause) {
		super(message, cause);
	}

	public VirementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
