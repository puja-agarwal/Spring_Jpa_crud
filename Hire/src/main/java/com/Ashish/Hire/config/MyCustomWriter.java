package com.Ashish.Hire.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Ashish.Hire.dao.Bdao;

import com.Ashish.Hire.entity.backgroundsync;


@Component
public class MyCustomWriter implements ItemWriter<backgroundsync> {
	
	@Autowired
	Bdao bd ;
	
	
	
	@Override
	public void write(List<? extends backgroundsync> list) throws Exception {
		// TODO Auto-generated method stub
		for (backgroundsync data : list) {
			
			System.out.println("MyCustomWriter    : Writing data    : " +data.getApplicant_name()+" : "+data.getEmail_id()+" : "+data.getFinal_verdict()+" "
					+ ": "+data.getRound_id()+" : "+data.getDate()+" : "+data.gettime());
			bd.save(data);
		}
		
	}
}
