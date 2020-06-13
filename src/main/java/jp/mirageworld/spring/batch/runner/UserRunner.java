package jp.mirageworld.spring.batch.runner;

import java.util.List;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import jp.mirageworld.spring.batch.ExitCode;
import jp.mirageworld.spring.batch.entity.User;
import jp.mirageworld.spring.batch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnProperty(name = "execute.app", havingValue = "user")
public class UserRunner
		extends CommandLineJobRunner
		implements ApplicationRunner {

	@Autowired
	UserRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> values = args.getNonOptionArgs();

		if (values.size() != 3) {
			log.warn("length error");
			exit(ExitCode.LENGTH_ERROR);
		}

		User user = new User();
		user.setUsername(values.get(0));
		user.setEmail(values.get(1));
		user.setPassword(values.get(2));

		if (repository.existsByEmail(user.getEmail())) {
			log.warn("unique error");
			exit(ExitCode.VALIDATION_ERROR);
		}

		if (repository.existsByEmail(user.getEmail())) {
			log.warn("unique error");
			exit(ExitCode.VALIDATION_ERROR);
		}

		if (args.containsOption("enable")) {
			user.setEnabled(true);
		}

		repository.save(user);
	}

}
