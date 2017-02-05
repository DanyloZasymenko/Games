package ua.com.games.validator.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.games.dao.GameDao;
import ua.com.games.entity.Game;
import ua.com.games.validator.main.ValidationException;
import ua.com.games.validator.main.Validator;

@Component("gameValidator")
public class GameValidator implements Validator<Game>{

	@Autowired
	private GameDao gameDao;
	
	@Override
	public void validate(Game object) throws Exception {
		
		Game game = (Game) object;
		
		if(game.getName().isEmpty()){
			throw new ValidationException(AdminValidationMessages.EMPTY_GAME_FIELD); 
		}
		
		if(gameDao.findByName(game.getName()) != null){
			throw new ValidationException(AdminValidationMessages.GAME_ALREADY_EXIST);
		}
		
		if(game.getYear() == 0){
			throw new ValidationException(AdminValidationMessages.EMPTY_YEAR_FIELD);
		}
		
		if(game.getYear() < 0){
			throw new ValidationException(AdminValidationMessages.WRONG_YEAR);
		}
		
	}

}
