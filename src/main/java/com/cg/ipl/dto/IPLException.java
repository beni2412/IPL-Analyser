package com.cg.ipl.dto;

public class IPLException extends Exception{

	enum ExceptionType {
	       WRONG_CSV, WRONG_TYPE, UNABLE_TO_PARSE
	    }

		ExceptionType type;

		public IPLException(String message, ExceptionType type) {
			super(message);
			this.type = type;
		}
}
