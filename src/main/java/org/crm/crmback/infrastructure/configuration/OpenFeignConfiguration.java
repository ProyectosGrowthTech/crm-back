package org.crm.crmback.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "org.crm.crmback.infrastructure.resources")
public class OpenFeignConfiguration {}
