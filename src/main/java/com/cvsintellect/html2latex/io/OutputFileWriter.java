package com.cvsintellect.html2latex.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.cvsintellect.html2latex.exception.FatalErrorException;

public class OutputFileWriter implements IWriter {
	/** Output file. */
	private BufferedWriter _writer;
	
	public OutputFileWriter(File outputFile) throws FatalErrorException {
		try {
			_writer = new BufferedWriter(new FileWriter(outputFile));
		}
		catch (IOException e) {
			throw new FatalErrorException("Can't open the output file: " + outputFile.getName());
		}
	}
	
	public void write(String str) throws IOException {
		_writer.write(str);
	}
	
	public void close() {
		try {
			_writer.close();
		}
		catch (IOException e) {
			System.err.println("Can't close the output file");
		}
	}

	@Override
	public String getOutput() {
		return null;
	}
}
