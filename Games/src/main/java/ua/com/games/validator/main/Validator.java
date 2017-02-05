package ua.com.games.validator.main;

public interface Validator <T>{

	void validate(T object) throws Exception;
	
}
