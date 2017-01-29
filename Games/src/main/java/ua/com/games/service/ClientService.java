package ua.com.games.service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import ua.com.games.dto.GameDTO;
import ua.com.games.entity.Client;
import ua.com.games.entity.Game;

public interface ClientService {

	void save(Client client) throws Exception;
	List<Client> findAll();
	Client findOne(int id);
	void delete(int id);
	
	void saveImage(Principal principal, MultipartFile multipartFile);
	
	Client findByUUID(String uuid);
	
	void update(Client client);	
	
	Set<Game> findGamesByClient(Principal principal);
	
	void deleteGameFromClient(Principal principal, int id);
}
