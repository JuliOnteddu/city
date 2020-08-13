package com.city.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * The Class CityControllerTest for unit testing.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Test connected end point with valid city routes.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConnectedEndPoint_WithSuccess() throws Exception {
		  MvcResult mvcResult = this.mockMvc.perform(get("/connected") .param("origin", "Boston")
		  .param("destination", "New York") ).andExpect(status().isOk()).andReturn();
		  String result = mvcResult.getResponse().getContentAsString();
		  assertEquals(result, "yes");
		 
	}
	
	/**
	 * Test connected end point with invalid city routes.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConnectedEndPoint_WithInvalidCityName() throws Exception {
		 MvcResult mvcResult = this.mockMvc.perform(get("/connected") .param("origin", "Boston")
				  .param("destination", "Los Angeles") ).andExpect(status().isOk()).andReturn();
				  String result = mvcResult.getResponse().getContentAsString();
				  assertEquals(result, "no");
	}
	
}
