package ua.com.games.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.games.entity.Genre;

public interface GenreDao extends JpaRepository<Genre, Integer>{

	Genre findByName(String name);
	
}
