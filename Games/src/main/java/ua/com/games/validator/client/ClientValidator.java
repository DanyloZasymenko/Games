package ua.com.games.validator.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.games.dao.ClientDao;
import ua.com.games.entity.Client;
import ua.com.games.validator.main.ValidationException;
import ua.com.games.validator.main.Validator;

@Component("clientValidator")
public class ClientValidator implements Validator<Client>{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public void validate(Client object) throws Exception {
		Client client = (Client) object;
		
		if(client.getName().isEmpty()){
			throw new ValidationException(ClientValidationMessages.EMPTY_USERNAME_FIELD);
		}
		
		if(client.getPassword().isEmpty()){
			throw new ValidationException(ClientValidationMessages.EMPTY_PASSWORD_FIELD);
		}
		
		if(client.getEmail().isEmpty()){
			throw new ValidationException(ClientValidationMessages.EMPTY_EMAIL_FIELD);
		}
		
		if(clientDao.findByName(client.getName()) != null){
			throw new ValidationException(ClientValidationMessages.NAME_ALREADY_EXIST);
		}
		
		if(clientDao.findByEmail(client.getEmail()) != null){
			throw new ValidationException(ClientValidationMessages.EMAIL_ALREADY_EXIST);
		}
		
	}

}
