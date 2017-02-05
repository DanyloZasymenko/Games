package ua.com.games.service;

import java.util.List;

import ua.com.games.entity.Game;

public interface GameService {

	void save(Game game) throws Exception;
	List<Game> findAll();
	Game findOne(int id);
	void delete(int id);
	
	void addDeveloperToGame(Game game, String developerId) throws Exception;
	void addGenresToGame(Game game, String [] genreIds) throws Exception;
}
