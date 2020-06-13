package jp.mirageworld.spring.batch;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "jp.mirageworld.spring.batch.repository")
@SpringBootApplication(scanBasePackages = "jp.mirageworld.spring.batch")
public class Application {

	public static void main(String[] args) {

		if (log.isDebugEnabled()) {
			ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
		} else {
			ToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
		}

		SpringApplication.run(Application.class, args);
	}

}
