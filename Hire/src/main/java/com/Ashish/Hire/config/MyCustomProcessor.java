package com.Ashish.Hire.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.Ashish.Hire.entity.backgroundsync;
import com.Ashish.Hire.entity.turbodata;



@Component
public class MyCustomProcessor implements ItemProcessor<backgroundsync, turbodata> {

	@Override
	public turbodata process(backgroundsync bsync) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+bsync);
		turbodata tdata = new turbodata();
		tdata.setInterview_id(bsync.getInterview_id());
		tdata.setApplicant_name(bsync.getApplicant_name());
		tdata.setEmail_id(bsync.getEmail_id());
		tdata.setFinal_verdict(bsync.getFinal_verdict());
		tdata.setRound_id(bsync.getRound_id());
		tdata.setDate(bsync.getDate());
		tdata.setTime(bsync.gettime());
		
//		
		return tdata;
	}


	
}
