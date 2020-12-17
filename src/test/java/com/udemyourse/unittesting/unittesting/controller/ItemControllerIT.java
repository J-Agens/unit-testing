package com.udemyourse.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.udemyourse.unittesting.unittesting.data.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
  
  @Autowired
  private TestRestTemplate restTemplate;
  
  //You an mock out any external resource with @MockBean
//  @MockBean
//  private ItemRepository repository;
  
  @Test
  public void contextLoads() throws JSONException {
    String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
    JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
  }

}
