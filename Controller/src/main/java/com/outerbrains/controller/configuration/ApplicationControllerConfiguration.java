package com.outerbrains.controller.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.outerbrains.service")
public class ApplicationControllerConfiguration {
}
