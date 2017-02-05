package ua.com.games.validator.admin;

import org.springframework.stereotype.Component;

import ua.com.games.validator.main.ValidationException;
import ua.com.games.validator.main.Validator;

@Component("selectValidator")
public class SelectValidator implements Validator <String>{

	@Override
	public void validate(String object) throws Exception {
		
		String str = object;
		
		if("noDeveloper".equals(str)){
			throw new ValidationException(AdminValidationMessages.CHOOSE_DEVELOPER);
		}
		
		if("noGenres".equals(str)){
			throw new ValidationException(AdminValidationMessages.CHOOSE_GENRES);
		}
		
		if("noGames".equals(str)){
			throw new ValidationException(AdminValidationMessages.CHOOSE_GAMES);
		}
	}

}
