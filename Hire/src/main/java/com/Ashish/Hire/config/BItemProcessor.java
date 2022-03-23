package com.Ashish.Hire.config;

import org.springframework.batch.item.ItemProcessor;

import com.Ashish.Hire.entity.turbodata;

public class BItemProcessor implements ItemProcessor<turbodata,turbodata>{

	@Override
	public turbodata process(turbodata tdata) throws Exception {
		// TODO Auto-generated method stub
		return tdata;
	}

}
