package com.hclmini.LearnBatch.Batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hclmini.LearnBatch.Repository.UserRepository;
import com.hclmini.LearnBatch.model.User;

@Component
public class DbWriter implements ItemWriter<User>{
	
	
	private UserRepository userRepository;
	
	@Autowired
	public DbWriter(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public void write(List<? extends User> users) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Data Saved For User:"+users);
		userRepository.saveAll(users);
	}

}
