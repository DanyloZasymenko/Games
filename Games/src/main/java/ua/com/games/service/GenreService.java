package ua.com.games.service;

import java.util.List;

import ua.com.games.entity.Genre;

public interface GenreService {

	void save(Genre genre) throws Exception;
	List<Genre> findAll();
	Genre findOne(int id);
	void delete(int id);
	
}
