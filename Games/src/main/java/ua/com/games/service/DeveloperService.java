package ua.com.games.service;

import java.util.List;

import ua.com.games.entity.Developer;

public interface DeveloperService {

	void save(Developer developer) throws Exception;
	List<Developer> findAll();
	Developer findOne(int id);
	void delete(int id);
	
}
