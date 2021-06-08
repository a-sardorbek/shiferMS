package com.bek.cement2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bek.cement2.entity.DailyInfo;

public interface DailyInfoRepository extends PagingAndSortingRepository<DailyInfo, Integer>{

	@Query(value = "SELECT * FROM dailyinfo d WHERE CONCAT(d.sana) LIKE %?1%" , nativeQuery = true)
	public Page<DailyInfo> search(String keyword, Pageable pageable);

//	@Query(value = "SELECT * FROM dailyinfo d  ORDER BY d.sana LIMIT 1",nativeQuery = true)
//	public List<DailyInfo> findLastInfoforadding();

	@Query(value = "select * from dailyinfo d where d.sana between ?1 and ?2",nativeQuery = true)
	public List<DailyInfo> findBydate(String start,String end);


}
