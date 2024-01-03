package com.example.demospringbatch.batch.config;


import com.example.demospringbatch.batch.listener.JobCompletionExecutionListener;
import com.example.demospringbatch.batch.processor.StudentProcessor;
import com.example.demospringbatch.batch.reader.StudentReader;
import com.example.demospringbatch.batch.writer.StudentWriter;
import com.example.demospringbatch.source.entity.Student;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
//    @Bean
//    public RepositoryItemReader<Student> reader(StudentSourceRepository studentSourceRepository) {
//        var result = new RepositoryItemReader<Student>();
//        result.setName("studentReader");
//        result.setRepository(studentSourceRepository);
//        result.setMethodName("findAll");
//        result.setPageSize(10);
//        result.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
//        return result;
//    }

//    @Bean
//    public RepositoryItemWriter<com.example.demospringbatch.target.entity.Student> writer(StudentTargetRepository studentTargetRepository) {
//        var result = new RepositoryItemWriterBuilder<com.example.demospringbatch.target.entity.Student>();
//        result.repository(studentTargetRepository);
//        result.methodName("save");
//        return result.build();
//    }

    @Autowired
    StudentReader studentReader;
    @Autowired
    StudentWriter studentWriter;
    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, StudentProcessor studentProcessor) {
        var result = new StepBuilder("studentStep", jobRepository);
        return result
                .<Student, com.example.demospringbatch.target.entity.Student> chunk(10, platformTransactionManager)
                .reader(studentReader.readAll())
                .writer(studentWriter.writeData())
                .processor(studentProcessor)
                .build();
    }



    @Bean
    public Job dataMigrationJob(JobRepository jobRepository, Step step, JobCompletionExecutionListener jobCompletionExecutionListener) {
        return new JobBuilder("dataMigrationJob", jobRepository)
                .start(step)
                .listener(jobCompletionExecutionListener)
                .build();
    }
//    @Bean(name = "jobLauncher")
//    public JobLauncher getJobLauncher() throws Exception {
//        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
//        jobLauncher.afterPropertiesSet();
//        return jobLauncher;
//    }
//    @Bean(name = "jobRepository")
//    public JobRepository getJobRepository() throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(sourceDatasource);
//        factory.setTransactionManager(platformTransactionManager);
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }


}
