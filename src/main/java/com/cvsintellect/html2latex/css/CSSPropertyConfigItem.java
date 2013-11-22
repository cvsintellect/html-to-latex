package com.cvsintellect.html2latex.css;

/**
 * Class representing configuration of each CSS property defined in the configuration file.
 */
public class CSSPropertyConfigItem {

	/**
	 * Mapping between the CSS property and LaTeX (start command). Example: <code>\texttt{<code> for &quot;monospace&quot; value
	 *  of &quot;font-family&quot; property.
	 */
	private String _start;
	
	/** Mapping between the CSS property and LaTeX (end command). */
	private String _end;

	/**
	 * Cstr.
	 * 
	 * @param start
	 *            start command
	 * @param end
	 *            end command
	 */
	public CSSPropertyConfigItem(String start, String end) {
		_start = start;
		_end = end;
	}

	/**
	 * Returns start command.
	 * 
	 * @return start command
	 */
	public String getStart() {
		return _start;
	}

	/*
	 * @return end command
	 */
	/**
	 * Returns end command.
	 * 
	 * @return end command
	 */
	public String getEnd() {
		return _end;
	}
}
