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

import ua.com.shop.dto.form.NumberOfSimCardsForm;
import ua.com.shop.service.NumberOfSimCardsService;
import ua.com.shop.validator.NumberOfSimCardsValidator;

@Controller
@RequestMapping("/admin/numberofsimcards")
@SessionAttributes("numberofsimcards")
public class NumberOfSimCardsController {

	@Autowired
	private NumberOfSimCardsService numberOfSimCardsService;

	@InitBinder("numberofsimcards")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new NumberOfSimCardsValidator(
				numberOfSimCardsService));
	}

	@ModelAttribute("numberofsimcards")
	public NumberOfSimCardsForm getForm() {
		return new NumberOfSimCardsForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("numberofsimcardss",
				numberOfSimCardsService.findAll());
		return "admin-numberofsimcards";
	}

	@PostMapping
	public String save(
			@ModelAttribute("numberofsimcards") @Valid NumberOfSimCardsForm numberOfSimCardsForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		numberOfSimCardsService.save(numberOfSimCardsForm);
		status.setComplete();
		return "redirect:/admin/numberofsimcards";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("numberofsimcards",
				numberOfSimCardsService.findForm(id));
		show(model);
		return "admin-numberofsimcards";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		numberOfSimCardsService.delete(id);
		return "redirect:/admin/numberofsimcards";
	}

}
