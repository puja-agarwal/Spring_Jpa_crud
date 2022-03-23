package com.Ashish.Hire.config;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.Ashish.Hire.entity.turbodata;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;

//coz we will define beans so configuration
@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
//	@Bean
//	public Job job(JobBuilderFactory jobBuilderFactory,StepBuilderFactory stepBuilderFactory,
//            ItemReader<User> itemReader,
//            ItemProcessor<User, User> itemProcessor,
//            ItemWriter<User> itemWriter
//)
//	{
//		  Step step = stepBuilderFactory.get("ETL-file-load")
//	                .<User, User>chunk(100)
//	                .reader(itemReader)
//	                .processor(itemProcessor)
//	                .writer(itemWriter)
//	                .build();
//
//
//	        return jobBuilderFactory.get("ETL-Load")
//	                .incrementer(new RunIdIncrementer())
//	                .start(step)
//	                .build();
//	    }
	
	
	@Bean
    public FlatFileItemReader<turbodata> itemReader() {

        FlatFileItemReader<turbodata> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("src/main/java/entity/backgroundsync.java"));
        reader.setName("Data-Reader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    @Bean
    public LineMapper<turbodata> lineMapper() {

        DefaultLineMapper<turbodata> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"interview_id", "applicant_name", "email_id", "round_id","time",
        		"date", "final_verdict"});
        lineTokenizer.setIncludedFields(new int[] {0,1,2,3,4,5,6});
        BeanWrapperFieldSetMapper<turbodata> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(turbodata.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
//    int interview_id, String applicant_name, String email_id, int round_id, String time,
//	String date, String final_verdict
	}


