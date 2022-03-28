package com.Ashish.Hire.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.Ashish.Hire.entity.backgroundsync;
import com.Ashish.Hire.entity.turbodata;



@Component
public class MyCustomProcessor implements ItemProcessor<turbodata,backgroundsync> {

	@Override
	public backgroundsync process(turbodata tdata) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+tdata);
		backgroundsync bsync = new backgroundsync();
		bsync.setInterview_id(tdata.getInterview_id());
		bsync.setApplicant_name(tdata.getApplicant_name());
		bsync.setEmail_id(tdata.getEmail_id());
		bsync.setFinal_verdict(tdata.getFinal_verdict());
		bsync.setRound_id(tdata.getRound_id());
		bsync.setDate(tdata.getDate());
		bsync.settime(tdata.getTime());
		
//		
		return bsync;
	}


	
}
