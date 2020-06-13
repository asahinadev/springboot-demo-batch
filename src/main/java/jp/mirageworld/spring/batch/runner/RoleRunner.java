package jp.mirageworld.spring.batch.runner;

import java.util.List;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import jp.mirageworld.spring.batch.ExitCode;
import jp.mirageworld.spring.batch.entity.Role;
import jp.mirageworld.spring.batch.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnProperty(name = "execute.app", havingValue = "role")
public class RoleRunner
		extends CommandLineJobRunner
		implements ApplicationRunner {

	@Autowired
	RoleRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> values = args.getNonOptionArgs();

		if (values.size() != 1) {
			log.warn("length error");
			exit(ExitCode.LENGTH_ERROR);
		}

		Role role = new Role();
		role.setName(values.get(0));

		if (repository.existsByName(role.getName())) {
			log.warn("unique error");
			exit(ExitCode.VALIDATION_ERROR);
		}
		repository.save(role);
	}

}
