package jp.mirageworld.spring.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "execute")
public class ExecuteConfig {
	String app;
}
