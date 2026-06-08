package com.erp.winkaws.mydb.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsername(String username);
	
	User findByUsername(String username);
	
	@Query("select u from User u left join fetch u.roles where u.id=:id")
	Optional<User> findByIdWithRoles(@Param("id") Integer id);
	
	@EntityGraph(attributePaths = {"authorities", "roles", "settings"})
	Page<User> findAll(Pageable pageable);
	
}
