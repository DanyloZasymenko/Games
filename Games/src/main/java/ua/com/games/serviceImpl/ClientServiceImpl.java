package ua.com.games.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.games.dao.ClientDao;
import ua.com.games.dao.GameDao;
import ua.com.games.dao.OfferDao;
import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.dto.GameDTO;
import ua.com.games.entity.Client;
import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;
import ua.com.games.entity.Orders;
import ua.com.games.entity.Role;
import ua.com.games.service.ClientService;
import ua.com.games.validator.main.Validator;

@Service("userDetailsService")
public class ClientServiceImpl implements ClientService, UserDetailsService {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private GameDao gameDao;

	@Autowired
	private OfferDao offerDao;

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	@Qualifier("clientValidator")
	private Validator validator;

	public void save(Client client) throws Exception {

		validator.validate(client);

		client.setRole(Role.ROLE_USER);
		client.setPassword(encoder.encode(client.getPassword()));
		clientDao.save(client);
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public Client findOne(int id) {
		return clientDao.findOne(id);
	}

	public void delete(int id) {
		clientDao.delete(id);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return clientDao.findByName(name);
	}

	public Client findByName(String name) {
		return clientDao.findByName(name);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		Client client = clientDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + client.getName() + "/"
				+ multipartFile.getOriginalFilename();

		client.setPathImage("resources/" + client.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + client.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("you have problems with file");
		}
	}

	@Override
	public Client findByUUID(String uuid) {
		return clientDao.findByUUID(uuid);
	}

	@Override
	public void update(Client client) {
		clientDao.save(client);
	}

	@Override
	@Transactional
	public Set<Game> findGamesByClient(Principal principal) {

		Client client = clientDao.findOne(Integer.parseInt(principal.getName()));

		List<Orders> orders = client.getOrders();

		Set<Game> games = new HashSet();

		for (Orders order : orders) {

			for (Game game : order.getGames()) {
				games.add(game);
			}
		}

		return games;
	}

	@Override
	public void deleteGameFromClient(Principal principal, int id) {
		
		Set<Game> games = clientService.findGamesByClient(principal);
		
		

	}

}