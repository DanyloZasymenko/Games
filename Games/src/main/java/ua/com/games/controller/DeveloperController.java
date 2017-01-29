package ua.com.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.games.dto.DeveloperDTO;
import ua.com.games.dto.DtoUtilMapper;
import ua.com.games.entity.Developer;
import ua.com.games.service.DeveloperService;
import ua.com.games.validator.admin.AdminValidationMessages;

@Controller
public class DeveloperController {

	@Autowired
	private DeveloperService developerService;

	@RequestMapping(value = "/newDeveloper", method = RequestMethod.GET)
	private String newDeveloper(Model model) {

		model.addAttribute("developerDTOs", DtoUtilMapper.developersToDevelopersDTO(developerService.findAll()));
		
		model.addAttribute("developerDTO", new DeveloperDTO());

		return "views-admin-newDeveloper";
	}

	@RequestMapping(value = "/saveDeveloper", method = RequestMethod.POST)
	private String saveDeveloper(@ModelAttribute DeveloperDTO developerDTO, Model model) {

		Developer developer = DtoUtilMapper.developerDTOToDeveloper(developerDTO);
		
		try {
			developerService.save(developer);
		} catch (Exception e) {
			if (e.getMessage().equals(AdminValidationMessages.EMPTY_DEVELOPER_FIELD)
					|| e.getMessage().equals(AdminValidationMessages.DEVELOPER_ALREADY_EXIST)) {
				model.addAttribute("developerException", e.getMessage());
			}
			return "views-admin-newDeveloper";
		}

		return "redirect:/newDeveloper";
	}

	@RequestMapping(value = "/deleteDeveloper/{id}", method = RequestMethod.GET)
	private String deleteDeveloper(@PathVariable int id) {

		developerService.delete(id);

		return "redirect:/newDeveloper";
	}

}
