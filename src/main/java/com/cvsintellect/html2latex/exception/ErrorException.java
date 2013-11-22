package com.cvsintellect.html2latex.exception;

/**
 * Error - not so heavy as {@link FatalErrorException fatal error}.
 */
public class ErrorException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Cstr.
	 * 
	 * @param str
	 *            error description
	 */
	public ErrorException(String str) {
		super("Error: " + str);
	}
}
