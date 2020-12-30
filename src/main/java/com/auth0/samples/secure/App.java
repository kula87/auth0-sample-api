package com.auth0.samples.secure;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties")
})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        List<Resource> resources = new LinkedList<Resource>();
        resources.add(new ClassPathResource("application.properties"));
        configurer.setLocations(resources.toArray(new Resource[0]));
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }
}
