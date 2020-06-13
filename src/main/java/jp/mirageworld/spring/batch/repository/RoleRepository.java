package jp.mirageworld.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mirageworld.spring.batch.entity.Role;

@Repository
public interface RoleRepository
		extends JpaRepository<Role, Integer> {

	public boolean existsByName(String name);

}
