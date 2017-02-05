package ua.com.games.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.games.dao.DeveloperDao;
import ua.com.games.dao.GameDao;
import ua.com.games.dao.GenreDao;
import ua.com.games.entity.Developer;
import ua.com.games.entity.Game;
import ua.com.games.entity.Genre;
import ua.com.games.service.GameService;
import ua.com.games.validator.main.Validator;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private GenreDao genreDao;
	
	@Autowired
	@Qualifier("gameValidator")
	private Validator<Game> validator;
	
	@Autowired
	@Qualifier("selectValidator")
	private Validator<String> selectValidator;
	
	public void save(Game game) throws Exception {
		
		validator.validate(game);
		
		gameDao.save(game);
	}

	public List<Game> findAll() {
		return gameDao.findAll();
	}

	public Game findOne(int id) {
		return gameDao.findOne(id);
	}

	public void delete(int id) {
		gameDao.delete(id);
	}
	
	@Override
	@Transactional
	public void addDeveloperToGame(Game game, String developerId) throws Exception {
		
			selectValidator.validate(developerId);
		
			Developer developer = developerDao.findOne(Integer.parseInt(developerId));
			
			game.setDeveloper(developer);
		
	}
	
	@Override
	@Transactional
	public void addGenresToGame(Game game, String[] genreIds) throws Exception {
		
		selectValidator.validate(genreIds[0]);
		
		List<Genre> genres = new ArrayList<>();
		
		for (int i = 0; i < genreIds.length; i++) {
			Genre genre = genreDao.findOne(Integer.parseInt(genreIds[i]));
			genres.add(genre);
		}
		
		game.setGenres(genres);
		
	}


	
	
}
