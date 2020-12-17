package com.udemyourse.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//You can use the @TestPropertySource annotation to specify a specific configuration file to use.
//(test-configuration.properties doesn't exist. You'd have to create it.)
//@TestPropertySource(locations= {"classpath:test-configuration.properties"})
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
