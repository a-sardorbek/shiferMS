package com.bek.cement2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bek.cement2.entity.DailyInfo;

public interface DailyInfoRepositoryBot extends JpaRepository<DailyInfo, Integer>{

	
	@Query(value = "select * from dailyinfo d order by d.sana desc limit 1",nativeQuery = true)
	public List<DailyInfo> findSana();
	
	@Query(value = "select * from dailyinfo d order by d.sana desc limit 1",nativeQuery = true)
	public Double findSana1();
	
}
