package com.Ashish.Hire.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ashish.Hire.entity.backgroundsync;
import com.Ashish.Hire.services.service;

@RestController
public class Mycontroller {
	
	
	@Autowired
	private service interviewService;
	
	
	 @Autowired
	 JobLauncher jobLauncher;

	  @Autowired
	  Job job;
	
	@PostMapping("/save-backgroundSync")
	
	public backgroundsync backgoundSyncData( @RequestBody backgroundsync bsync) {
		return this.interviewService.backgoundSyncData(bsync);
		}
	
	@GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }

}

