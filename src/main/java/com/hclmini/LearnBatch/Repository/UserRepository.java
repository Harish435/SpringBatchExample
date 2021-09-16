package com.hclmini.LearnBatch.Repository;

import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclmini.LearnBatch.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//List<User> findByName( String name);

}
