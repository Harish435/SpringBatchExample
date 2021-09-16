package com.hclmini.LearnBatch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hclmini.LearnBatch.Repository.UserRepository;
import com.hclmini.LearnBatch.model.User;

@SpringBootTest
@SpringBatchTest
public class UserBatchTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	
	@AfterEach
	public void cleanup() {
		userRepository.deleteAll();
	}
	
	private void createAccount(String...id) {
		for(String ids:id) {
			User user=new User(1, "radhika", "Technology", 24000, 32, new Date());
			userRepository.save(user);
			}
	}
	
	@Test
	public void should_process_all_records() throws Exception
	{
		createAccount("3");
		createAccount("4");
		JobExecution jobExecution=jobLauncherTestUtils.launchJob(buildJobparameters());
		assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("COMPLETED");
		assertThat(userRepository.count()).isEqualTo(5);
	}
	
	@Test
	public void should_NOT_process_Error_occurs() throws Exception
	{
		createAccount("3777");
		
		JobExecution jobExecution=jobLauncherTestUtils.launchJob(buildJobParameters("invalid.csv"));
		//assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("FAILED");
		assertThat(userRepository.count()).isEqualTo(5);
	}
	
	/*
	 * @Test public void should_skip_records_when_Not_Found() throws Exception {
	 * createAccount("3"); JobExecution
	 * jobExecution=jobLauncherTestUtils.launchJob(buildJobparameters());
	 * 
	 * assertThat(userRepository.findByName("radhika").size()).isEqualTo("radhi");
	 * assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("FAILED");
	 * assertThat(userRepository.count()).isEqualTo(8); }
	 */

	private JobParameters buildJobparameters() {
		// TODO Auto-generated method stub
		return buildJobParameters("users.csv");
	}

	private JobParameters buildJobParameters(String filepath) {
		// TODO Auto-generated method stub
		return new JobParametersBuilder().addString("pathTotranactionFile", filepath)
				.addLong("CurrentTimeInMillis", System.currentTimeMillis()).toJobParameters();
	}
	
}
