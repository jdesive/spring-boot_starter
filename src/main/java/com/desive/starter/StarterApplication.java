package com.desive.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class StarterApplication extends SpringApplication{

	public StarterApplication(final Class<?> clazz) {
		super(clazz);
	}

	public static void main(String[] args) {
		new StarterApplication(AppConfig.class).run(args);
	}

}
