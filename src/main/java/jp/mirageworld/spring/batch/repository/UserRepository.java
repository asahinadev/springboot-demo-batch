package jp.mirageworld.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mirageworld.spring.batch.entity.User;

@Repository
public interface UserRepository
		extends JpaRepository<User, Integer> {

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);
}
