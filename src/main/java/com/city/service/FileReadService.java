package com.city.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;


public class FileReadService {
	
	@Value("${city.file.name}")
	private String fileName;

	/**
	 * @param origin
	 * @param destination
	 * @return whether route found or not
	 * @throws IOException
	 */
	public String readFile(String origin, String destination) throws IOException{
		File file;
		BufferedReader bufferedReader = null;
			file = ResourceUtils.getFile("classpath:" + fileName);
			bufferedReader = new BufferedReader(new FileReader(file));
			String line1;
			while ((line1 = bufferedReader.readLine()) != null) {
				if (line1.contains(origin) && line1.contains(destination)) {
				String[] split = line1.split(",");
				if((split[0].trim().equalsIgnoreCase(origin) && split[1].trim().equalsIgnoreCase(destination)) ||
						split[0].trim().equalsIgnoreCase(destination) && split[1].trim().equalsIgnoreCase(origin))
					return "yes";
				}
			}
				bufferedReader.close();
		return "no";
	}
	
}
