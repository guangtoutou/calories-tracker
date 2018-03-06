package com.ningning.auth;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String email);
}
