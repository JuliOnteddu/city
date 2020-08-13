package com.city.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.city.controller.CityController;

/**
 * The Class FileReadServiceTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class FileReadServiceTest {

	/** The file read service. */
	@Mock
	private FileReadService fileReadService;
	
	/**
	 * Test read file with success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testReadFile_withSuccess()  throws Exception{
		when(fileReadService.readFile("Boston", "New York")).thenReturn("yes");
		String result = fileReadService.readFile("Boston", "New York");
		assertEquals(result, "yes");
	}
	
	/**
	 * Test read file with failure.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testReadFile_withFailure()  throws Exception{
		when(fileReadService.readFile("Boston", "Los Angeles")).thenReturn("no");
		String result = fileReadService.readFile("Boston", "Los Angeles");
		assertEquals(result, "no");
	}
}
