package com.orgchart.orgchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.orgchart.orgchart.controller.RestApiController;

/**
 * @author YOG1HC
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = RestApiController.class)
public class OrgchartApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrgchartApplication.class, args);
	}

}
