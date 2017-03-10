package ua.com.shop.controller.admin;

import static ua.com.shop.util.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import ua.com.shop.dto.filter.SimpleFilterDecimal;
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

	@ModelAttribute("filter")
	public SimpleFilterDecimal getFilter() {
		return new SimpleFilterDecimal();
	}

	@ModelAttribute("numberofsimcards")
	public NumberOfSimCardsForm getForm() {
		return new NumberOfSimCardsForm();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		model.addAttribute("page",
				numberOfSimCardsService.findAll(pageable, filter));
		return "admin-numberofsimcards";
	}

	@PostMapping
	public String save(
			@ModelAttribute("numberofsimcards") @Valid NumberOfSimCardsForm numberOfSimCardsForm,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		numberOfSimCardsService.save(numberOfSimCardsForm);
		status.setComplete();
		return "redirect:/admin/numberofsimcards" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		model.addAttribute("numberofsimcards",
				numberOfSimCardsService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		numberOfSimCardsService.delete(id);
		return "redirect:/admin/numberofsimcards" + getParams(pageable, filter);
	}

}
