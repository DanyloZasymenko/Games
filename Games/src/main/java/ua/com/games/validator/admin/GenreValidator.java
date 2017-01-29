package ua.com.games.validator.admin;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.games.dao.GenreDao;
import ua.com.games.entity.Genre;
import ua.com.games.validator.main.Validator;

@Component("genreValidator")
public class GenreValidator implements Validator{

	@Autowired
	private GenreDao genreDao;
	
	@Override
	public void validate(Object object) throws Exception {
		
		Genre genre = (Genre) object;
		
		if(genre.getName().isEmpty()){
			throw new ValidationException(AdminValidationMessages.EMPTY_GENRE_FIELD);
		}
		
		if(genreDao.findByName(genre.getName()) != null){
			throw new ValidationException(AdminValidationMessages.GENRE_ALREADY_EXIST);
		}
		
	}

}
