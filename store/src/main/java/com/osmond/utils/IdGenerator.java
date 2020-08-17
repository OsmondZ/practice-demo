package com.osmond.utils;

import java.util.UUID;

public class IdGenerator {
	public static String getGenerator(String fileName) {
		String name = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
		return name;
	}
}
