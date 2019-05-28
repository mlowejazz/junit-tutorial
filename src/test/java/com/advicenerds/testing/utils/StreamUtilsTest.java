package com.advicenerds.testing.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Marcus Lowe
 *
 */
public class StreamUtilsTest {

	@Test
	public void testFilterStartsWithIgnoreCase() {
		String spy = "James Bond";
		String fruit = "banana";
		String filter = "james";
		List<String> list = Arrays.asList(fruit,spy);
		assertTrue(StreamUtils.filterStartsWithIgnoreCase(list, filter).contains(spy));
		assertFalse(StreamUtils.filterEndsWithIgnoreCase(list, filter).contains(fruit));
	}

}
