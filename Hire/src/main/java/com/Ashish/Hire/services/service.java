package com.Ashish.Hire.services;

import com.Ashish.Hire.entity.backgroundsync;
//import com.Ashish.Hire.entity.userdata;
import com.Ashish.Hire.entity.turbodata;

public interface service {

//	 public void SaveBackgroundSync( );
	backgroundsync backgoundSyncData(backgroundsync bsync );
	turbodata turboSyncData(turbodata tdata );
}
