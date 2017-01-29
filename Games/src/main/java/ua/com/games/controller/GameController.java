package ua.com.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.games.dto.DeveloperDTO;
import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.dto.GameDTO;
import ua.com.games.dto.GenreDTO;
import ua.com.games.entity.Developer;
import ua.com.games.entity.Game;
import ua.com.games.service.DeveloperService;
import ua.com.games.service.GameService;
import ua.com.games.service.GenreService;
import ua.com.games.validator.admin.AdminValidationMessages;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@Autowired
	private DeveloperService developerService;

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/newGame", method = RequestMethod.GET)
	private String newGame(Model model) {

		model.addAttribute("gameDTOs", DtoUtilMapper.gamesToGamesDTO(gameService.findAll()));
		model.addAttribute("gameDTO", new GameDTO());
		model.addAttribute("developerDTOs", DtoUtilMapper.developersToDevelopersDTO(developerService.findAll()));
		model.addAttribute("genreDTOs", DtoUtilMapper.genresToGenresDTO(genreService.findAll()));

		return "views-admin-newGame";
	}

	@RequestMapping(value = "/deleteGame/{id}", method = RequestMethod.GET)
	private String deleteGame(@PathVariable int id) {

		gameService.delete(id);

		return "redirect:/newGame";

	}

	@RequestMapping(value = "/saveGame", method = RequestMethod.POST)
	private String saveGame(@ModelAttribute GameDTO gameDTO, @RequestParam String developerId,
			@RequestParam String[] genreIds, Model model) {

		Game game = DtoUtilMapper.gameDTOToGame(gameDTO);
		
		gameService.addDeveloperToGame(game, developerId);

		gameService.addGenresToGame(game, genreIds);

		try {
			gameService.save(game);
		} catch (Exception e) {
			if (e.getMessage().equals(AdminValidationMessages.EMPTY_GAME_FIELD)
					|| e.getMessage().equals(AdminValidationMessages.GAME_ALREADY_EXIST)) {
				model.addAttribute("gameException", e.getMessage());
			} else if (e.getMessage().equals(AdminValidationMessages.EMPTY_YEAR_FIELD)
					|| e.getMessage().equals(AdminValidationMessages.WRONG_YEAR)) {
				model.addAttribute("yearException", e.getMessage());
			}
			return "views-admin-newGame";
		}

		return "redirect:/newGame";
	}

}
