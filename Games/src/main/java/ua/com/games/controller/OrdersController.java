package ua.com.games.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.games.entity.Client;
import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;
import ua.com.games.entity.Orders;
import ua.com.games.service.ClientService;
import ua.com.games.service.OfferService;
import ua.com.games.service.OrdersService;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private OfferService offerService;

	@RequestMapping(value = "/toBasket/{id}", method = RequestMethod.GET)
	public String toBasket(Principal principal, @PathVariable int id) {

		Client client = clientService.findOne(Integer.parseInt(principal.getName()));

		Offer offer = offerService.findOne(id);
		
//		Set<Game> games = clientService.findGamesByClient(principal);
//		
//		for (Game game : offer.getGames()){
//			games.add(game);
//		}
		
		Orders order = new Orders(offer.getPrice(), offer.getGames(), client);

		ordersService.save(order);

		return "redirect:/profile";
	}

}
