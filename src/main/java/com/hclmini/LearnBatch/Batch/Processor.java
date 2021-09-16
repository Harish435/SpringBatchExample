package com.hclmini.LearnBatch.Batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.hclmini.LearnBatch.model.User;

@Component
public class Processor implements ItemProcessor<User, User> {

	private static final Map<String,String> Dept_Names=new HashMap<>();
	
	public Processor() {
		Dept_Names.put("001", "Technology");
		Dept_Names.put("002", "Operation");
		Dept_Names.put("003", "Accounts");
		
	}
	
	@Override
	public User process(User user) throws Exception {
		
		String deptcode=user.getDept();
		String dept=Dept_Names.get(deptcode);
		user.setDept(dept);
		user.setTime(new Date());
		
		return user;
	}

}
