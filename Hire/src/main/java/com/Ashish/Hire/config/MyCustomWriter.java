package com.Ashish.Hire.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Ashish.Hire.dao.turbodatadao;
import com.Ashish.Hire.entity.turbodata;


@Component
public class MyCustomWriter implements ItemWriter<turbodata> {
	
	@Autowired
	turbodatadao tdao ;
	
	
	
	@Override
	public void write(List<? extends turbodata> list) throws Exception {
		// TODO Auto-generated method stub
		for (turbodata data : list) {
//			System.out.println("MyCustomWriter    : Writing data    : " + data.getFinal_verdict()+" : "+data.getInterview_id()+" : "+data.getEmail_id()+" : "+data.getRound_id()+" "
//					+ ": "+data.getTime()+" : "+data.getApplicant_name()+" : "+data.getDate());
			System.out.println("MyCustomWriter    : Writing data    : " +data.getInterview_id() +" : "+data.getApplicant_name()+" : "+data.getEmail_id()+" : "+data.getFinal_verdict()+" "
					+ ": "+data.getRound_id()+" : "+data.getDate()+" : "+data.getTime());
			tdao.save(data);
		}
		
	}
}
