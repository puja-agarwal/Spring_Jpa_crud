package com.Ashish.Hire.config;

//public class MyCustomReader {
//
//}

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Ashish.Hire.entity.backgroundsync;


@Component
public class MyCustomReader extends JdbcCursorItemReader<backgroundsync> implements ItemReader<backgroundsync>{
	
	public MyCustomReader(@Autowired DataSource primaryDataSource) {
		setDataSource(primaryDataSource);
		setSql("SELECT interview_id,applicant_name,email_id,final_verdict,round_id,date,time FROM backgroundsync");
				 
		setFetchSize(100);
		setRowMapper(new bsyncRowMapper());
	}
	
	public class bsyncRowMapper implements RowMapper<backgroundsync> {
		@Override
		public backgroundsync mapRow(ResultSet rs, int rowNum) throws SQLException {
			backgroundsync bsync  = new backgroundsync();
			bsync.setInterview_id(rs.getInt("interview_id"));
			bsync.setApplicant_name(rs.getString("applicant_name"));
			bsync.setEmail_id(rs.getString("email_id"));
			bsync.setFinal_verdict(rs.getString("final_verdict"));
			bsync.setRound_id(rs.getInt("round_id"));
			bsync.setDate(rs.getString("date"));
			
			
			
			
			bsync.settime(rs.getString("time"));
			return bsync;
		}
	}
}