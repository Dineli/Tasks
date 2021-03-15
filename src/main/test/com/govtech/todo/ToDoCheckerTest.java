package com.govtech.todo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class to test the functionality of the TODO Checker To run the below
 * test case pass the below argument e.g.: -Dfilepath=<DIR LOCATION>
 * 
 * @author dineli
 *
 */
public class ToDoCheckerTest {

	public ToDoCheckerTest() {
	}

	@Test
	@DisplayName("Check Main API of the TodoChecker")
	void testTodoChecker() {
		String dirPath = System.getProperty("filepath");
		String[] args = new String[] { dirPath };

		try {
			ToDoChecker.main(args);
		} catch (Exception ex) {
			fail("Exception occured, scenario not handled");
		}
	}

	@Test
	@DisplayName("Check ToDoChecker Exception handling for invalid dir path")
	void testIncorrectDirPath() {
		String[] args = null;
		try {
			ToDoChecker.main(args);
		} catch (Exception ex) {
			fail("Exception not handled");
		}
	}

	@Test
	@DisplayName("Check Read Directory for Exception handling")
	void testReadDirectoryError() {
		try {
			ToDoChecker.readDirectory(null);
		} catch (Exception ex) {
			fail("Exception not handled");
		}
	}

}
