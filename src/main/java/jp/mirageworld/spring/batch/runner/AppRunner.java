package jp.mirageworld.spring.batch.runner;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import jp.mirageworld.spring.batch.ExitCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnProperty(name = "execute.app", havingValue = "app")
public class AppRunner
		extends CommandLineJobRunner
		implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.warn("execute.app not found");
		exit(ExitCode.NOT_FOUND);
	}

}
