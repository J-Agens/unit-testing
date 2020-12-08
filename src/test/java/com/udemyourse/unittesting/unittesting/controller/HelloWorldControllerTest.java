package com.udemyourse.unittesting.unittesting.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  public void helloWorld_basic() throws Exception {
    //call "/hello-world" application/json
    RequestBuilder request = MockMvcRequestBuilders
        .get("/hello-world")
        .accept(MediaType.APPLICATION_JSON);
    
    MvcResult result = mockMvc.perform(request)
        .andExpect(status().isOk()) // can also use status codes
        .andExpect(content().string("Hello World")) // can replace .string with .json if you need json
        .andReturn();
    
    // verify the response contains "Hello World"
    
    // the below assertEquals is not needed because our response is very simple
    // and our .andExpect is covering it.
    
    //assertEquals("Hello World", result.getResponse().getContentAsString());
  }
}
