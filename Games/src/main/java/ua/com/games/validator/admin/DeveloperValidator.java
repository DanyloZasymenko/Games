package ua.com.games.validator.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.games.dao.DeveloperDao;
import ua.com.games.entity.Developer;
import ua.com.games.validator.main.ValidationException;
import ua.com.games.validator.main.Validator;

@Component("developerValidator")
public class DeveloperValidator implements Validator<Developer>{
	
	@Autowired
	private DeveloperDao developerDao;

	@Override
	public void validate(Developer object) throws Exception {
		
		Developer developer = (Developer) object;
		
		if(developer.getName().isEmpty()){
			throw new ValidationException(AdminValidationMessages.EMPTY_DEVELOPER_FIELD);
		}
		
		if(developerDao.findByName(developer.getName()) != null){
			throw new ValidationException(AdminValidationMessages.DEVELOPER_ALREADY_EXIST);
		}
				
	}
	
}
