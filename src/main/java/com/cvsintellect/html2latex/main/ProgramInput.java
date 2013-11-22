package com.cvsintellect.html2latex.main;

public class ProgramInput {
	/** Input HTML file. */
	private String inputFile = "";

	/** Output LaTeX file. */
	private String outputFile = "";

	/** Configuration file. */
	private String configFile = "config.xml";

	/** File with CSS. */
	private String cssFile = "";

	/**
	 * Processes command line arguments.
	 * <ul>
	 * <li>-input &lt;fileName&gt;</li>
	 * <li>-output &lt;fileName&gt;</li>
	 * <li>-config &lt;fileName&gt;</li>
	 * <li>-css &lt;fileName&gt;</li>
	 * </ul>
	 * 
	 * @param args
	 *            command line arguments
	 */
	public void processCmdLineArgs(String[] args) {
		for (int i = 0; i < args.length; ++i) {
			if (args[i].equals("-input")) {
				if (i < (args.length - 1)) {
					inputFile = args[i + 1];
					++i;
				}
			}

			if (args[i].equals("-output")) {
				if (i < (args.length - 1)) {
					outputFile = args[i + 1];
					++i;
				}
			}

			if (args[i].equals("-config")) {
				if (i < (args.length - 1)) {
					configFile = args[i + 1];
					++i;
				}
			}

			if (args[i].equals("-css")) {
				if (i < (args.length - 1)) {
					cssFile = args[i + 1];
					++i;
				}
			}
		}
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public String getCssFile() {
		return cssFile;
	}

	public void setCssFile(String cssFile) {
		this.cssFile = cssFile;
	}
}
