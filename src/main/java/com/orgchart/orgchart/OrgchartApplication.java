package com.orgchart.orgchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author YOG1HC
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.orgchart.orgchart.controller", "com.orgchart.orgchart"})
@CrossOrigin(origins = "http://localhost:8080")
public class OrgchartApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrgchartApplication.class, args);
	}

}
