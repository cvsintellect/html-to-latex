package com.cvsintellect.html2latex.exception;

/**
 * Configuration item (element, entity, CSS property) wasn't found in the configuration.
 */
public class NoItemException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Cstr.
	 * 
	 * @param item
	 *            item name
	 */
	public NoItemException(String item) {
		super("Can't find specified config item " + item);
	}
}
