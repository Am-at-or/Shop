package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Display;
import ua.com.shop.service.DisplayHeightService;
import ua.com.shop.service.DisplayService;
import ua.com.shop.service.DisplaySizeService;
import ua.com.shop.service.DisplayTechnologyService;
import ua.com.shop.service.DisplayWidthService;

@Controller
@RequestMapping("/admin/display")
@SessionAttributes("display")
public class DisplayController {

	@Autowired
	private DisplayService displayService;

	@Autowired
	private DisplaySizeService displaySizeService;

	@Autowired
	private DisplayTechnologyService displayTechnologyService;

	@Autowired
	private DisplayWidthService displayWidthService;

	@Autowired
	private DisplayHeightService displayHeightService;
	

	@ModelAttribute("display")
	public Display getForm() {
		return new Display();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displays", displayService.findAll());
		model.addAttribute("displaywidths", displayWidthService.findAll());
		model.addAttribute("displayheights", displayHeightService.findAll());
		model.addAttribute("displaysizes", displaySizeService.findAll());
		model.addAttribute("displaytechnologies",
				displayTechnologyService.findAll());
		return "admin-display";
	}

	@PostMapping
	public String save(@ModelAttribute("display") Display display,
			SessionStatus status) {
		displayService.save(display);
		status.setComplete();
		return "redirect:/admin/display";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("display", displayService.findOne(id));
		show(model);
		return "admin-display";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayService.delete(id);
		return "redirect:/admin/display";
	}

}
