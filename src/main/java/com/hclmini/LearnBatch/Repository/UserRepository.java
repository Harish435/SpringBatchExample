package com.hclmini.LearnBatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hclmini.LearnBatch.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
