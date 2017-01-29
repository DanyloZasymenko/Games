package ua.com.games.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.entity.Client;
import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;
import ua.com.games.entity.Orders;
import ua.com.games.service.ClientService;
import ua.com.games.service.GameService;
import ua.com.games.service.OfferService;
import ua.com.games.service.OrdersService;

@Controller
public class HomeController {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home(Model model){
		
		model.addAttribute("offerDTOs", DtoUtilMapper.offersToOffersDTO(offerService.findAll()));
		model.addAttribute("gameDTOs", DtoUtilMapper.gamesToGamesDTO(gameService.findAll()));
		
		return "views-base-home";
	}
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.POST)
	public String homePost(){
		return "views-base-home";
	}
	
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login(){
		return "views-base-loginpage";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	
	
}
