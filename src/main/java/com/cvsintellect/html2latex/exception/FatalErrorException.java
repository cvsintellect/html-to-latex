/*
 * FatalErrorException.java
 */

package com.cvsintellect.html2latex.exception;

/**
 * Fatal error - leads to program exit.
 */
public class FatalErrorException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Cstr.
	 * 
	 * @param str
	 *            error description
	 */
	public FatalErrorException(String str) {
		super("Fatal error: " + str);
	}
}
