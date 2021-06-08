package com.bek.cement2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bek.cement2.entity.DailyInfo;
import com.bek.cement2.repository.DailyInfoRepositoryBot;

@Service
public class DailyInfoServiceBot {
	
	@Autowired
	private DailyInfoRepositoryBot bot;
	
	public List<DailyInfo> findAll(){ 
		return bot.findAll();
	}
	
	public List<DailyInfo> findSana(){
		return bot.findSana();
	}

	
	public Double findSana1(){
		return bot.findSana1();
	}
}
