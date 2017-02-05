package ua.com.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.dto.OfferDTO;
import ua.com.games.entity.Offer;
import ua.com.games.service.GameService;
import ua.com.games.service.OfferService;
import ua.com.games.validator.admin.AdminValidationMessages;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/newOffer", method = RequestMethod.GET)
	public String newOffer(Model model) {

		// model.addAttribute("gamesFromOffer",
		// offerService.findGamesFromOffer(id));
		addModels(model);

		return "views-admin-newOffer";
	}

	private void addModels(Model model) {
		model.addAttribute("gameDTOs", DtoUtilMapper.gamesToGamesDTO(gameService.findAll()));
		model.addAttribute("offerDTOs", DtoUtilMapper.offersToOffersDTO(offerService.findAll()));
	}

	@RequestMapping(value = "/deleteOffer/{id}", method = RequestMethod.GET)
	public String deleteOffer(@PathVariable String id) {
		offerService.delete(Integer.parseInt(id));
		return "redirect:/newOffer";
	}

	@RequestMapping(value = "/saveOffer", method = RequestMethod.POST)
	public String saveOffer(@ModelAttribute OfferDTO offerDTO, @RequestParam String[] gameIds, Model model) {

		Offer offer = DtoUtilMapper.offerDTOToOffer(offerDTO);

		try {
			offerService.addGamesToOffer(offer, gameIds);
			offerService.save(offer);
		} catch (Exception e) {
			/*
			 * if
			 * (e.getMessage().equals(AdminValidationMessages.EMPTY_OFFER_FIELD)
			 * ) { model.addAttribute("offerException", e.getMessage()); } else
			 * if (e.getMessage().equals(AdminValidationMessages.WRONG_PRICE)) {
			 * model.addAttribute("priceException", e.getMessage()); }
			 */
			model.addAttribute("Exception", e.getMessage());
			addModels(model);
			return "views-admin-newOffer";
		}

		return "redirect:/newOffer";
	}

}
