package com.example.demospringbatch.batch.listener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobCompletionExecutionListener implements JobExecutionListener {
    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Job Id: {}", jobExecution.getJobId());
    }
}
