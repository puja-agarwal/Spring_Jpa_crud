package com.Ashish.Hire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class backgroundsync {
	
	@Id	
	 private int interview_id;
	
	private String applicant_name;
	
	private String email_id;
	 private int round_id;
	 @JsonFormat(pattern="yyyy-MM-dd",shape=JsonFormat.Shape.STRING)
	 
	 @Column(name="time")
	 private String time;
	 
	 @Column(name="date")
	 @JsonFormat(pattern="HH:mm:ss",shape=JsonFormat.Shape.STRING)
	 
	 private String date;
	 
	 private String final_verdict;
	 
	 public backgroundsync(int interview_id, String applicant_name, String email_id, int round_id, String time,
			String date, String final_verdict) {
		super();
		this.interview_id = interview_id;
		this.applicant_name = applicant_name;
		this.email_id = email_id;
		this.round_id = round_id;
		this.time = time;
		this.date = date;
		this.final_verdict = final_verdict;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getInterview_id() {
		return interview_id;
	}
	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
	}
	public String getApplicant_name() {
		return applicant_name;
	}
	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getRound_id() {
		return round_id;
	}
	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}
	public String gettime() {
		return time;
	}
	public void settime(String time) {
		this.time = time;
	}
	public String getFinal_verdict() {
		return final_verdict;
	}
	public void setFinal_verdict(String final_verdict) {
		this.final_verdict = final_verdict;
	}
	
	public backgroundsync() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	
	 
	
	
	

}
