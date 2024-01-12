package com.david.blogproject.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.david.BlogprojectApplication;
import com.david.controller.HelloController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(HelloController.class)
@ExtendWith(SpringExtension.class)
public class HelloControllerTest{
	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	@WithMockUser
	public void hello_ReturnsHelloSpringBoot() throws Exception{
		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("hello Spring boot!"));
	}
	
	@Test
	@WithMockUser
	public void helloDto_Test() throws Exception{
		String name = "minsu";
		String nickname = "babo";
		
		mvc.perform(
				get("/hello/dto")
						.param("name", name)
						.param("nickname", nickname))
					.andExpect( status().isOk())
					.andExpect( jsonPath("$.name", is(name)))
					.andExpect( jsonPath("$.nickname", is(nickname)));	
		
     	}
	}
	
	
	
	