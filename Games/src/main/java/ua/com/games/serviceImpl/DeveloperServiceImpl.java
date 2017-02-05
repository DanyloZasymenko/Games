package ua.com.games.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.games.dao.DeveloperDao;
import ua.com.games.dao.GameDao;
import ua.com.games.entity.Developer;
import ua.com.games.entity.Game;
import ua.com.games.service.DeveloperService;
import ua.com.games.validator.main.Validator;

@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	@Qualifier("developerValidator")
	private Validator<Developer> validator;
	
	public void save(Developer developer) throws Exception {
		
		validator.validate(developer);
		
		developerDao.save(developer);
	}

	public List<Developer> findAll() {
		return developerDao.findAll();
	}

	public Developer findOne(int id) {
		return developerDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		
		Developer developer = developerDao.findOne(id);
		
		for (Game game : developer.getGames()) {
			game.setDeveloper(null);
			gameDao.save(game);
		}
		
		developerDao.delete(id);
	}

}
