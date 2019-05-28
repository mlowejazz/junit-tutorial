package com.advicenerds.testing.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.advicenerds.testing.model.User;

/**
 * 
 * @author Marcus Lowe
 *
 */
public class StreamUtils {
	
	private StreamUtils() {
		
	}

	public static List<String> filterStartsWithIgnoreCase(List<String> list, String startStr) {
		return list.stream().
				filter(s -> s.toUpperCase().startsWith(startStr.toUpperCase())).
				collect(Collectors.toList());
	}
	
	public static List<String> filterEndsWithIgnoreCase(List<String> list, String endString) {
		return list.stream().
				filter(s -> s.toUpperCase().endsWith(endString.toUpperCase())).
				collect(Collectors.toList());
	}
	
	public static List<String> getEmailAddressesFromUser(List<User> users) {
		return users.stream().map(User::getEmailAddress).collect(Collectors.toList());
	}
	
	public static List<String> getEmailAddressesForDomainFromUsers(List<User> users, String domain) {
		return filterEndsWithIgnoreCase(getEmailAddressesFromUser(users),domain);
	}
}
