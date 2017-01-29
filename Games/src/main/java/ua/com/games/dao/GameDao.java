package ua.com.games.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.games.entity.Game;

public interface GameDao extends JpaRepository<Game, Integer>{
	
	Game findByName(String name);
	
}
