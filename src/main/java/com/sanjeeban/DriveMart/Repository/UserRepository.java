package com.sanjeeban.DriveMart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanjeeban.DriveMart.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	
	@Query("select t from User t where t.username=:username")
	public User findByUsername(@Param("username")String username);
	
}
