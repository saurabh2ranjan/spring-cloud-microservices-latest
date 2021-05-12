package com.programming.techie.propertyaccess;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix = "property-file")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyAccessBean {
	private String name;
	private String description;
}
