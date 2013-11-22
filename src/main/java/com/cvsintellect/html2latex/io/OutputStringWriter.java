package com.cvsintellect.html2latex.io;

import java.io.IOException;

public class OutputStringWriter implements IWriter {

	private StringBuilder output;

	public OutputStringWriter() {
		output = new StringBuilder();
	}

	@Override
	public void write(String str) throws IOException {
		output.append(str);
	}

	@Override
	public void close() {

	}

	public String getOutput() {
		return output.toString();
	}
}
