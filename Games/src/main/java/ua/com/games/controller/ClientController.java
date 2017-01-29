package ua.com.games.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.games.dao.ClientDao;
import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.entity.Client;
import ua.com.games.entity.Game;
import ua.com.games.entity.Orders;
import ua.com.games.service.ClientService;
import ua.com.games.service.GameService;
import ua.com.games.service.MailSenderService;
import ua.com.games.validator.client.ClientValidationMessages;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private GameService gameService;

	@Autowired
	private MailSenderService mailSenderService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String saveClient(Model model) {

		model.addAttribute("clientDTOs", DtoUtilMapper.clientsToClientsDTO(clientService.findAll()));
		model.addAttribute("client", new Client());

		return "views-client-registration";
	}

	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute Client client, Model model) {

		String uuid = UUID.randomUUID().toString();

		client.setUuid(uuid);

		try {
			clientService.save(client);
		} catch (Exception e) {
			if (e.getMessage().equals(ClientValidationMessages.EMPTY_USERNAME_FIELD)
					|| e.getMessage().equals(ClientValidationMessages.NAME_ALREADY_EXIST)) {
				model.addAttribute("nameException", e.getMessage());
			} else if (e.getMessage().equals(ClientValidationMessages.EMPTY_EMAIL_FIELD)
					|| e.getMessage().equals(ClientValidationMessages.EMAIL_ALREADY_EXIST)) {
				model.addAttribute("emailException", e.getMessage());
			} else if (e.getMessage().equals(ClientValidationMessages.EMPTY_PASSWORD_FIELD)) {
				model.addAttribute("passwordException", e.getMessage());
			}
			return "views-client-registration";
		}

		String theme = "Thank's for registration";
		String mailBody = "Administration Games.com.ua congratulates you on a successful registration.\n"
				+ "Follow this link to complete registration: http://localhost:8080/Games/confirm/" + uuid;

		mailSenderService.sendMail(theme, mailBody, client.getEmail());

		return "redirect:/";
	}

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid) {

		Client client = clientService.findByUUID(uuid);
		client.setEnabled(true);

		clientService.update(client);

		return "redirect:/";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		model.addAttribute("clientDTO",
				DtoUtilMapper.clientToClientDTO(clientService.findOne(Integer.parseInt(principal.getName()))));

		Set<Game> games = clientService.findGamesByClient(principal);
		// List<Game> games = new ArrayList<>();
		/*
		 * for (Integer gameId : gameIds) {
		 * games.add(gameService.findOne(gameId)); }
		 */
		model.addAttribute("listGames", games);

		return "views-client-profile";
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {

		clientService.saveImage(principal, image);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/deleteGameFromClient/{id}", method = RequestMethod.GET)
	public String deleteGameFromClient(@PathVariable int id) {

		return "redirect:/profile";
	}
/*
	@RequestMapping(value = "/playGame/{id}", method = RequestMethod.GET)
	public String playGame(@PathVariable int id, Model model, Principal principal) {

		model.addAttribute("clientDTO",
				DtoUtilMapper.clientToClientDTO(clientService.findOne(Integer.parseInt(principal.getName()))));
		model.addAttribute("gameDTO", DtoUtilMapper.gameToGameDTO(gameService.findOne(id)));
		
		return "views-base-playGame";
	}
*/
}
