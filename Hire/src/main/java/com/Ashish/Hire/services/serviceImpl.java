package com.Ashish.Hire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashish.Hire.dao.Bdao;
import com.Ashish.Hire.entity.backgroundsync;


@Service
public class serviceImpl implements service {

	
	

	@Autowired(required=false)
	private Bdao dao;
	
	
	
	@Override
	 public backgroundsync backgoundSyncData(backgroundsync bsync ) {
					 dao.save(bsync);
			return bsync;
		}



	
}
