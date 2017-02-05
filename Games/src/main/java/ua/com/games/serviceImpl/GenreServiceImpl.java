package ua.com.games.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.games.dao.GenreDao;
import ua.com.games.entity.Genre;
import ua.com.games.service.GenreService;
import ua.com.games.validator.main.Validator;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreDao genreDao;
	
	@Autowired
	@Qualifier("genreValidator")
	private Validator<Genre> validator;
	
	public void save(Genre genre) throws Exception {
		
		validator.validate(genre);
		
		genreDao.save(genre);
	}

	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	public Genre findOne(int id) {
		return genreDao.findOne(id);
	}

	public void delete(int id) {
		genreDao.delete(id);
	}

}
