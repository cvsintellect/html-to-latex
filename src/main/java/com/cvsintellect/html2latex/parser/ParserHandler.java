package com.cvsintellect.html2latex.parser;

import java.io.File;
import java.io.IOException;

import com.cvsintellect.html2latex.config.Configuration;
import com.cvsintellect.html2latex.converter.Converter;
import com.cvsintellect.html2latex.exception.FatalErrorException;
import com.cvsintellect.html2latex.exception.NoItemException;
import com.cvsintellect.html2latex.main.ProgramInput;

/**
 * Handles events sent from the {@link Parser Parser} class. Calls appropriate methods from the {@link Converter Convertor} class.
 */
public class ParserHandler implements IParserHandler {

	/** Convertor. */
	private Converter _converter;

	public ParserHandler(String configPath) throws FatalErrorException {
		_converter = new Converter(configPath);
	}
	
	public ParserHandler(Configuration config) throws FatalErrorException {
		_converter = new Converter(config);
	}
	
	/**
	 * Cstr.
	 * 
	 * @param outputFile
	 *            output LaTeX file
	 * @throws FatalErrorException
	 *             fatal error (ie. output file can't be closed) occurs
	 */
	public ParserHandler(File outputFile, ProgramInput programInput) throws FatalErrorException {
		_converter = new Converter(outputFile, programInput);
	}
	
	public Converter getConverter() {
		return _converter;
	}

	/**
	 * Called when a start element is reached in the input document. Calls {@link Converter#commonElementStart(ElementStart) commonElementStart()} for
	 * non-special elements and specials methods for the elements requiring special care (ie. {@link Converter#tableRowStart(ElementStart) tableRowStart()} for
	 * <code>&lt;table&gt;</table>)
	 * 
	 * @param element
	 *            start element reached
	 */
	public void startElement(ElementStart element) {
		try {
			String name = element.getElementName();

			if (name.equals("a"))
				_converter.anchorStart(element);
			else if (name.equals("tr"))
				_converter.tableRowStart(element);
			else if (name.equals("td"))
				_converter.tableCellStart(element);
			else if (name.equals("th"))
				_converter.tableCellStart(element);
			else if (name.equals("meta"))
				_converter.metaStart(element);
			else if (name.equals("body"))
				_converter.bodyStart(element);
			else if (name.equals("font"))
				_converter.fontStart(element);
			else if (name.equals("img"))
				_converter.imgStart(element);
			else if (name.equals("table"))
				_converter.tableStart(element);
			else
				_converter.commonElementStart(element);

			_converter.cssStyleStart(element);
		}
		catch (IOException e) {
			System.err.println("Can't write into output file");
		}
		catch (NoItemException e) {
			System.out.println(e);
			// e.printStackTrace();
		}
	}

	/**
	 * Called when an end element is reached in the input document. Calls {@link Converter#commonElementEnd(ElementEnd, ElementStart) commonElementEnd()} for
	 * non-special elements and specials methods for the elements requiring special care (ie. {@link Converter#tableRowEnd(ElementEnd, ElementStart)
	 * tableRowEnd()} for <code>&lt;/table&gt;</table>)
	 * 
	 * @param element
	 *            end element reached
	 * @param elementStart
	 *            corresponding start element
	 */
	public void endElement(ElementEnd element, ElementStart elementStart) {
		try {
			String name = element.getElementName();

			_converter.cssStyleEnd(elementStart);

			if (name.equals("a"))
				_converter.anchorEnd(element, elementStart);
			else if (name.equals("tr"))
				_converter.tableRowEnd(element, elementStart);
			else if (name.equals("th"))
				_converter.tableCellEnd(element, elementStart);
			else if (name.equals("td"))
				_converter.tableCellEnd(element, elementStart);
			else if (name.equals("table"))
				_converter.tableEnd(element, elementStart);
			else if (name.equals("body"))
				_converter.bodyEnd(element, elementStart);
			else if (name.equals("font"))
				_converter.fontEnd(element, elementStart);
			else
				_converter.commonElementEnd(element, elementStart);

		}
		catch (IOException e) {
			System.err.println("Can't write into output file.");
		}
		catch (NoItemException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Called when the text content of an element is read. Calls {@link Converter#characters(String) characters()} method of the {@link Converter Convertor}
	 * class.
	 * 
	 * @param content
	 *            ie. &quot;foo&quot; for the &quot;&lt;b&gt;foo&lt;/b&gt;&quot;
	 */
	public void characters(String content) {
		try {
			_converter.characters(content);
		}
		catch (IOException e) {
			System.err.println("Can't write into output file.");
		}
	}

	/**
	 * Called when the comment is reached in input document. Calls {@link Converter#comment(String) comment()} method of the {@link Converter Convertor} class.
	 * 
	 * @param comment
	 *            ie. &quot;foo&quot; for the &quot;&lt;!--&gt;foo&lt;/--&gt;&quot;
	 */
	public void comment(String comment) {
		try {
			_converter.comment(comment);
		}
		catch (IOException e) {
			System.err.println("Can't write into output file.");
		}
	}

	/**
	 * Called when the whole input document is read. Calls {@link Converter#destroy() destroy()} method of the {@link Converter Convertor} class.
	 */
	public void endDocument() {
		_converter.destroy();
	}
}
