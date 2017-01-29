package ua.com.games.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.games.entity.Developer;

public interface DeveloperDao extends JpaRepository<Developer, Integer>{

	Developer findByName(String name);
	
}
