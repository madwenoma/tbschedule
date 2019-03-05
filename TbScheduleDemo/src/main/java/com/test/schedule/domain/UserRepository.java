package com.test.schedule.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

	@Query(value = "SELECT u FROM User u where u.id % ?1 = ?2")
	List<User> findAll(long a, long b);

}
