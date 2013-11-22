package com.cvsintellect.html2latex.io;

import java.io.IOException;

import com.cvsintellect.html2latex.exception.FatalErrorException;

public interface IReader {
	public int read() throws IOException;
	
	public void close() throws FatalErrorException;
}
