package com.Ashish.Hire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashish.Hire.dao.Bdao;
import com.Ashish.Hire.dao.turbodatadao;
import com.Ashish.Hire.entity.backgroundsync;
import com.Ashish.Hire.entity.turbodata;


@Service
public class serviceImpl implements service {

	
	

	@Autowired(required=false)
	private Bdao dao;
	
	@Autowired(required=false)
	private turbodatadao tdao;
	
	
	
	@Override
	 public backgroundsync backgoundSyncData(backgroundsync bsync ) {
					 dao.save(bsync);
			return bsync;
		}
	
	
	@Override
	 public turbodata turboSyncData(turbodata tdata ) {
		tdao.save(tdata);
			return tdata;
		}



	
}
