package net.drewdouglass.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.drewdouglass.Entity.OffensiveStats;
@Configuration
public class BeanConfiguration {

	@Bean
	public OffensiveStats stats() {
		OffensiveStats bean = new OffensiveStats();
		return bean;
	}
	
}
