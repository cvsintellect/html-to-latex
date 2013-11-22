package com.cvsintellect.html2latex.converter;

/**
 * The way of converting hyperlinks.
 */
public enum LinksConversion {
	/** Hyperlinks will be converted into the footnotes containing the link. */
	FOOTNOTES,

	/** Hyperlinks will be converted into the bibliography items. */
	BIBLIO,

	/**
	 * Hyperlinks will be converted using the hyperref package which is built on hypertex package. Hyperlinks starting with &quot;#&quot; are also included.
	 */
	HYPERTEX,

	/** Hyperlinks are ignored. */
	IGNORE
}
