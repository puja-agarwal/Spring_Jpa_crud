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
import com.Ashish.Hire.entity.turbodata;


@Component
public class MyCustomReader extends JdbcCursorItemReader<turbodata> implements ItemReader<turbodata>{
	
	public MyCustomReader(@Autowired DataSource primaryDataSource) {
		setDataSource(primaryDataSource);
		setSql("SELECT interview_id,applicant_name,email_id,final_verdict,round_id,date,time FROM turbodata");
				 
		setFetchSize(100);
		setRowMapper(new turboRowMapper());
	}
	
	public class turboRowMapper implements RowMapper<turbodata> {
		@Override
		public turbodata mapRow(ResultSet rs, int rowNum) throws SQLException {
			turbodata tdata  = new turbodata();
			tdata.setInterview_id(rs.getInt("interview_id"));
			tdata.setApplicant_name(rs.getString("applicant_name"));
			tdata.setEmail_id(rs.getString("email_id"));
			tdata.setFinal_verdict(rs.getString("final_verdict"));
			tdata.setRound_id(rs.getInt("round_id"));
			tdata.setDate(rs.getString("date"));
			
			
			
			
			tdata.setTime(rs.getString("time"));
			return tdata;
		}
	}
}