package com.hclmini.LearnBatch.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;

	@GetMapping
	public BatchStatus Load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		JobParameters parameters=new JobParameters();
		Map<String, JobParameter> map=new HashMap<String, JobParameter>();
		map.put("time",new JobParameter(System.currentTimeMillis()) );
		
		
		JobExecution jobExecution= jobLauncher.run(job, parameters);
		
		System.out.println("jobEx:"+jobExecution.getStatus());
		
		//To check whether  job excecution is completed or not
		while(jobExecution.isRunning()) {
			System.out.println(".....");
		}
		
		return jobExecution.getStatus();
	}
}
