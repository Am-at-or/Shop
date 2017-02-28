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

import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.service.DisplayTechnologyService;
import ua.com.shop.validator.DisplayTechnologyValidator;

@Controller
@RequestMapping("/admin/displaytechnology")
@SessionAttributes("displaytechnology")
public class DisplayTechnologyController {

	@Autowired
	private DisplayTechnologyService displayTechnologyService;

	@InitBinder("displaytechnology")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplayTechnologyValidator(
				displayTechnologyService));
	}

	@ModelAttribute("displaytechnology")
	public DisplayTechnology getForm() {
		return new DisplayTechnology();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displaytechnologies",
				displayTechnologyService.findAll());
		return "admin-displaytechnology";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displaytechnology") @Valid DisplayTechnology displayTechnology,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		displayTechnologyService.save(displayTechnology);
		status.setComplete();
		return "redirect:/admin/displaytechnology";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displaytechnology",
				displayTechnologyService.findOne(id));
		show(model);
		return "admin-displaytechnology";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayTechnologyService.delete(id);
		return "redirect:/admin/displaytechnology";
	}

}
