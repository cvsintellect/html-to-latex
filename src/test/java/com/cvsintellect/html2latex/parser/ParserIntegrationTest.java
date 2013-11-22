package com.cvsintellect.html2latex.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.cvsintellect.html2latex.config.Configuration;
import com.cvsintellect.html2latex.exception.FatalErrorException;
import com.cvsintellect.html2latex.main.ProgramInput;
import com.cvsintellect.html2latex.parser.Parser;

public class ParserIntegrationTest {
	private static final String NL = "\n";
	private static final String TAB = "\t";

	private static Configuration _config;

	@Before
	public void setup() throws FatalErrorException {
		if (_config == null) {
			URL url = this.getClass().getResource("/config.xml");
			String configPath = url.getFile();
			ProgramInput programInput = new ProgramInput();
			programInput.setConfigFile(configPath);
			_config = new Configuration(programInput);
		}
	}

	@Test
	public void shouldNotConvertNonHTMLString() {
		String input = "there is no HTML here!";
		String expectedOutput = input;
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertSpecialCharacters() {
		String input = "# $ % ^ & _ { } ~ \\";
		String expectedOutput = "\\# \\$ \\% \\textasciicircum & \\_ \\{ \\} \\textasciitilde $\\backslash$";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertBoldTag() {
		String input = "there is a <strong>bold text</strong> tag";
		String expectedOutput = "there is a \\textbf{bold text} tag";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertUnderlineTag() {
		String input = "there is a <u>underline text</u> tag";
		String expectedOutput = "there is a \\underline{underline text} tag";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertItalicsTag() {
		String input = "there is a <i>italics text</i> tag";
		String expectedOutput = "there is a \\textit{italics text} tag";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertUnorderedListTag() {
		String input = "there is a list tag <ul><li>text A</li><li>text B</li><li>text C</li></ul>";
		String expectedOutput = "there is a list tag " + NL + "\\begin{itemize}" + NL + TAB + "\\item text A" + NL + TAB + "\\item text B" + NL + TAB
				+ "\\item text C" + NL + "\\end{itemize}";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertOrderedListTag() {
		String input = "there is a list tag <ol><li>text A</li><li>text B</li><li>text C</li></ol>";
		String expectedOutput = "there is a list tag " + NL + "\\begin{enumerate}" + NL + TAB + "\\item text A" + NL + TAB + "\\item text B" + NL + TAB
				+ "\\item text C" + NL + "\\end{enumerate}";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertMultipleTags() {
		String input = "there is a <strong>bold text</strong> <u>underline text</u> <i>italics text</i> tags";
		String expectedOutput = "there is a \\textbf{bold text}\\underline{underline text}\\textit{italics text} tags";
		parse(input, expectedOutput);
	}

	@Test
	public void shouldConvertNestedTagStructure() {
		String input = "there is a list tag <ul><li><strong><u><i>text A</i></u></strong></li><li>text B</li><li>text C</li></ul>";
		String expectedOutput = "there is a list tag " + NL + "\\begin{itemize}" + NL + TAB + "\\item \\textbf{\\underline{\\textit{text A}}}" + NL + TAB
				+ "\\item text B" + NL + TAB + "\\item text C" + NL + "\\end{itemize}";
		parse(input, expectedOutput);
	}

	private void parse(String input, String expectedOutput) {
		try {
			Parser parser = new Parser(input, _config);
			parser.parse();
			String output = parser.getParserHandler().getConverter().getWriter().getOutput();
			assertEquals(expectedOutput, output);
		}
		catch (Exception e) {
			fail(e.getStackTrace().toString());
		}
	}
}
