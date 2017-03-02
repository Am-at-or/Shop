package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.DisplayHeightEditor;
import ua.com.shop.editor.DisplaySizeEditor;
import ua.com.shop.editor.DisplayTechnologyEditor;
import ua.com.shop.editor.DisplayWidthEditor;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplaySize;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayHeightService;
import ua.com.shop.service.DisplayService;
import ua.com.shop.service.DisplaySizeService;
import ua.com.shop.service.DisplayTechnologyService;
import ua.com.shop.service.DisplayWidthService;
import ua.com.shop.validator.DisplayValidator;

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

	@InitBinder("display")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(DisplaySize.class, new DisplaySizeEditor(
				displaySizeService));
		binder.registerCustomEditor(DisplayWidth.class, new DisplayWidthEditor(
				displayWidthService));
		binder.registerCustomEditor(DisplayHeight.class,
				new DisplayHeightEditor(displayHeightService));
		binder.registerCustomEditor(DisplayTechnology.class,
				new DisplayTechnologyEditor(displayTechnologyService));
		binder.setValidator(new DisplayValidator(displayService));
	}

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
	public String save(@ModelAttribute("display") @Valid Display display,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
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
