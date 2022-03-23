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
		
		tdata.setDate(bsync.getDate());
		tdata.setFinal_verdict(bsync.getFinal_verdict());
		tdata.setInterview_id(bsync.getInterview_id());
		tdata.setEmail_id(bsync.getEmail_id());
		tdata.setRound_id(bsync.getRound_id());
		tdata.setTime(bsync.gettime());
		tdata.setDate(bsync.getDate());
		tdata.setDate(bsync.getDate());
		return tdata;
	}


	
}
