package agroWeb.controller;


import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.*;

import static com.jayway.jsonpath.JsonPath.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.is;

public class FirstControllerTest {

	
	@InjectMocks 
//	private FirstController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
	//	mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	/*@Test
	public void test() throws Exception{
		mockMvc.perform(post("/test")
				.content("{\"title\":\"Test Blog Title\"}")
				.contentType(MediaType.APPLICATION_JSON)
	//			).andExpect(jsonPath("$.title", is("Test Blog Title")))
		//		.andDo(print());
		
	}*/
}
