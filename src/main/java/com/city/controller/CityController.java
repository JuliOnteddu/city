package com.city.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.service.FileReadService;

/**
 * The Class CityController.
 */
@RestController
public class CityController {
	
	/** Inject FileReadService object. */
	@Autowired
	private FileReadService fileReadService;

	/**
	 * Checks if is city connected.
	 *
	 * @param origin the origin
	 * @param destination the destination
	 * @return the string whether route found oe not
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/connected")
	public String isCityConnected(@RequestParam(required = true) String origin,
			@RequestParam(required = true) String destination) throws IOException {
		return fileReadService.readFile(origin, destination);

	}
	
}
