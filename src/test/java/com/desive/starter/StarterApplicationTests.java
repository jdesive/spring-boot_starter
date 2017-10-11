/*
 * Copyright (C) 2017  Jack DeSive
 *
 * This file is part of Spring Boot Starter.
 *
 * Spring Boot Starter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
