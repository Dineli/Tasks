package com.govtech.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Class to Check for Todo Code snippets given a source folder location
 * 
 * @author dineli
 *
 */
public class ToDoChecker {

	static List<String> result = new ArrayList<String>();
	private static final Logger LOGGER = Logger.getLogger(ToDoChecker.class.getName());

	public static void main(String[] args) {
		try {
			File rootPath = new File(args[0]);
			readDirectory(rootPath);
			if (null != result && result.size() > 0) {
				LOGGER.info("Files with TODO keyword: ");
				for (String file : result) {
					System.out.println(file);
				}
			} else {
				LOGGER.info("No files found with TODO keyword");
			}
		} catch (NullPointerException e) {
			LOGGER.warning("Invalid file path, please re-check!");
		} catch (ArrayIndexOutOfBoundsException arr) {
			LOGGER.warning("Invalid command line argument, please re-check!");
		}
	}

	public static void readDirectory(File dir) {
		if (dir == null) {
			return;
		}

		String output;
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				readDirectory(file);
			} else {
				output = readFile(file);
				if (null != output) {
					result.add(dir.getAbsoluteFile() + "\\" + output);
				}
			}
		}
	}

	public static String readFile(File file) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			LOGGER.warning("File not found!" + e.getMessage());
		}
		while (scanner.hasNextLine()) {
			String lineFromFile = scanner.nextLine();
			if (lineFromFile.contains("TODO")) {
				return file.getName();
			}
		}
		return null;
	}

}
