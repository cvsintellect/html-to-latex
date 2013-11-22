package com.cvsintellect.html2latex.parser;

import java.util.HashMap;

/**
 * Class representing HTML start element.
 */
public class ElementStart extends MyElement {

	/** Map containing all element's attributtes with their values. */
	private HashMap<String, String> _attributes;

	/**
	 * Cstr.
	 * 
	 * @param element
	 *            element's name
	 * @param attributes
	 *            element's attributes
	 */
	public ElementStart(String element, HashMap<String, String> attributes) {
		_element = element;
		_attributes = attributes;
	}

	/**
	 * Returns element's attributes.
	 * 
	 * @return element's attributes
	 */
	public HashMap<String, String> getAttributes() {
		return _attributes;
	}

}