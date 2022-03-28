package com.Ashish.Hire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class turbodata {
	
	@Id	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private int interview_id;
	
	private String applicant_name;
	
	 private String email_id;
	 
	 private int round_id;
	 
	 
	 @Column(name="time")
	 @JsonFormat(pattern="HH:mm:ss",shape=JsonFormat.Shape.STRING)
	 private String time;
	 
	 @Column(name="date")
	 @JsonFormat(pattern="yyyy-MM-dd",shape=JsonFormat.Shape.STRING)
	 private String date;
	 
	 private String final_verdict;
	
	
	public turbodata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public turbodata(int interview_id, String applicant_name, String email_id, int round_id, String time, String date,String final_verdict) {
		super();
		this.interview_id = interview_id;
		this.applicant_name = applicant_name;
		this.email_id = email_id;
		this.round_id = round_id;
		this.time = time;
		this.date = date;
		this.final_verdict = final_verdict;
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
	
	public String getFinal_verdict() {
		return final_verdict;
	}
	public void setFinal_verdict(String final_verdict) {
		this.final_verdict = final_verdict;
	}
	public int getRound_id() {
		return round_id;
	}
	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
