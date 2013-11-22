package com.cvsintellect.html2latex.converter;

/**
 * Class representing configuration of each HTML element.
 */
public class ElementConfigItem {
	/**
	 * Mapping between start tag and LaTeX command. (ie. &quot;\textbf{&quot; for the <code>b</code> tag).
	 */
	private String _start;
	
	/**
	 * Mapping between end tag and LaTeX command. (ie. &quot;}&quot; for the <code>b</code> tag).
	 */
	private String _end;
	/** The element's content mustn't be touched. (ie. for <code>pre</code>) */
	private boolean _leaveText = false;
	
	/** The element's content will be ignored. (ie. for <code>script</code>) */
	private boolean _ignoreContent = false;
	
	/** The element's CSS style will be ignored. */
	private boolean _ignoreStyles = false;

	/**
	 * Cstr.
	 * 
	 * @param start
	 *            mapping between start tag and LaTeX command
	 * @param end
	 *            mapping between end tag and LaTeX command
	 * @param leaveText
	 *            &quot;yes&quot; if the element's content mustn't be touched
	 * @param ignoreContent
	 *            &quot;yes&quot; if the element's content will be ignored
	 * @param ignoreStyles
	 *            &quot;yes&quot; if the element's CSS styles will be ignored
	 */
	public ElementConfigItem(String start, String end, String leaveText, String ignoreContent, String ignoreStyles) {
		_start = start;
		_end = end;
		if (leaveText.equals("yes")) {
			_leaveText = true;
		}
		if (ignoreContent.equals("yes")) {
			_ignoreContent = true;
		}
		if (ignoreStyles.equals("yes")) {
			_ignoreStyles = true;
		}
	}

	/**
	 * Returns mapping between start tag and LaTeX command.
	 * 
	 * @return mapping between start tag and LaTeX command
	 */
	public String getStart() {
		return _start;
	}

	/**
	 * Returns mapping between end tag and LaTeX command.
	 * 
	 * @return mapping between end tag and LaTeX command
	 */
	public String getEnd() {
		return _end;
	}

	/**
	 * Returns leaveText property.
	 * 
	 * @return true if the element's content mustn't be touched
	 */
	public boolean leaveText() {
		return _leaveText;
	}

	/**
	 * Returns ignoreContent property.
	 * 
	 * @return true if the element's content is ignored
	 */
	public boolean ignoreContent() {
		return _ignoreContent;
	}

	/**
	 * Returns ignoreStyles property.
	 * 
	 * @return true if the element's CSS styles are ignored
	 */
	public boolean ignoreStyles() {
		return _ignoreStyles;
	}
}
