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

import ua.com.shop.dto.form.CardMemoryForm;
import ua.com.shop.service.CardMemoryService;
import ua.com.shop.validator.CardMemoryValidator;

@Controller
@RequestMapping("/admin/cardmemory")
@SessionAttributes("cardmemory")
public class CardMemoryController {

	@Autowired
	private CardMemoryService cardMemoryService;

	@InitBinder("cardmemory")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new CardMemoryValidator(cardMemoryService));
	}

	@ModelAttribute("cardmemory")
	public CardMemoryForm getForm() {
		return new CardMemoryForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("cardmemories", cardMemoryService.findAll());
		return "admin-cardmemory";
	}

	@PostMapping
	public String save(
			@ModelAttribute("cardmemory") @Valid CardMemoryForm cardMemoryForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		cardMemoryService.save(cardMemoryForm);
		status.setComplete();
		return "redirect:/admin/cardmemory";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("cardmemory", cardMemoryService.findForm(id));
		show(model);
		return "admin-cardmemory";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		cardMemoryService.delete(id);
		return "redirect:/admin/cardmemory";
	}

}
