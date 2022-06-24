package com.assessment.game.fizzbuzzapi;

import com.assessment.game.fizzbuzzapi.controller.ApiController;
import com.assessment.game.fizzbuzzapi.controller.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
class SpringbootFizzbuzzApplicationTests {

	 @InjectMocks
	 ApiController apiController;
	 private MockMvc mockMvc;
	 @Autowired
	 private WebApplicationContext webApplicationContext;

	 @BeforeEach
	 protected void setUp(){
	 	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	 }

	@Test
	void testFizzBuzzAlgorithm1to100() {
		String result = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz,31,32,Fizz,34,Buzz,Fizz,37,38,Fizz,Buzz,41,Fizz,43,44,FizzBuzz,46,47,Fizz,49,Buzz,Fizz,52,53,Fizz,Buzz,56,Fizz,58,59,FizzBuzz,61,62,Fizz,64,Buzz,Fizz,67,68,Fizz,Buzz,71,Fizz,73,74,FizzBuzz,76,77,Fizz,79,Buzz,Fizz,82,83,Fizz,Buzz,86,Fizz,88,89,FizzBuzz,91,92,Fizz,94,Buzz,Fizz,97,98,Fizz,Buzz";
		Service service = new Service();
		Assertions.assertEquals(result, service.getResultStringFor1To100());
	}

	@Test
	void testFizzBuzzAlgorithm1ToN() {
		String result = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";
		Service service = new Service();
		Assertions.assertEquals(result, service.getResultStringFor1ToN(15));
	}

	@Test
	void testFizzBuzzAlgorithm1ToN_Negative() {
		String result = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,Fizz";
		Service service = new Service();
		Assertions.assertNotEquals(result, service.getResultStringFor1ToN(15));
	}

	@Test
	void testRestApiCall() throws Exception{
		MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/print1to100")
				.accept(MediaType.TEXT_PLAIN)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
	}

	@Test
	void testRestApiCall_() throws Exception{
		String result = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz,31,32,Fizz,34,Buzz,Fizz,37,38,Fizz,Buzz,41,Fizz,43,44,FizzBuzz,46,47,Fizz,49,Buzz,Fizz,52,53,Fizz,Buzz,56,Fizz,58,59,FizzBuzz,61,62,Fizz,64,Buzz,Fizz,67,68,Fizz,Buzz,71,Fizz,73,74,FizzBuzz,76,77,Fizz,79,Buzz,Fizz,82,83,Fizz,Buzz,86,Fizz,88,89,FizzBuzz,91,92,Fizz,94,Buzz,Fizz,97,98,Fizz,Buzz";
		MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/print1to100")
				.accept(MediaType.TEXT_PLAIN)).andReturn();
		String status = mvcResult.getResponse().getContentAsString();
		Assertions.assertEquals(result, status);
	}
}
