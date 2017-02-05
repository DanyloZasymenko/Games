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
import ua.com.games.dto.GenreDTO;
import ua.com.games.entity.Genre;
import ua.com.games.service.GenreService;
import ua.com.games.validator.admin.AdminValidationMessages;

@Controller
public class GenreController {

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/newGenre", method = RequestMethod.GET)
	private String newGenre(Model model) {

		addModels(model);

		return "views-admin-newGenre";
	}

	private void addModels(Model model) {
		model.addAttribute("genreDTOs", DtoUtilMapper.genresToGenresDTO(genreService.findAll()));
		
		model.addAttribute("genreDTO", new GenreDTO());
	}

	@RequestMapping(value = "/saveGenre", method = RequestMethod.POST)
	private String saveGenre(@ModelAttribute GenreDTO genreDTO, Model model) {

		Genre genre = DtoUtilMapper.genreDTOToGenre(genreDTO);
		
		try {
			genreService.save(genre);
		} catch (Exception e) {
			if (e.getMessage().equals(AdminValidationMessages.EMPTY_GENRE_FIELD)
					|| e.getMessage().equals(AdminValidationMessages.GENRE_ALREADY_EXIST)) {
				model.addAttribute("genreException", e.getMessage());
			}
			addModels(model);
			return "views-admin-newGenre";
		}

		return "redirect:/newGenre";
	}

	@RequestMapping(value = "/deleteGenre/{id}", method = RequestMethod.GET)
	private String deletGenre(@PathVariable int id) {

		genreService.delete(id);

		return "redirect:/newGenre";
	}

}
