package com.desive.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(StarterApplication.class)
@ContextConfiguration(classes = StarterApplication.class)
@PropertySource("classpath:application-test.properties")
public class StarterApplicationTests {

	@Test
	public void contextLoads(){
		// This doesn't really do anything.
		new StarterApplication();
	}

}
