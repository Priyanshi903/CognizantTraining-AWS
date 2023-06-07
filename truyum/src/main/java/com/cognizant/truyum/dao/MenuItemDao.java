package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Long> {
	
	@Query(value="select * from menu_item where active=true and  date_of_launch<=?1 ", nativeQuery = true)
	public List<MenuItem> findByActiveDateOfLaunchLessThan(Date date);

}
