package com.morethanheroic.uppercase.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class LowercaseService {

	public String lowercase(final String input) {
		return input.toLowerCase(Locale.ENGLISH);
	}
}
