package com.Ashish.Hire.config;

import org.springframework.batch.item.ItemProcessor;

import com.Ashish.Hire.entity.backgroundsync;
import com.Ashish.Hire.entity.turbodata;

public class BItemProcessor implements ItemProcessor<backgroundsync,backgroundsync>{

	@Override
	public backgroundsync process(backgroundsync bsync) throws Exception {
		// TODO Auto-generated method stub
		return bsync;
	}

}
