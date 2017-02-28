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

import ua.com.shop.entity.Maker;
import ua.com.shop.service.MakerService;
import ua.com.shop.validator.MakerValidator;

@Controller
@RequestMapping("/admin/maker")
@SessionAttributes("maker")
public class MakerController {

	@Autowired
	private MakerService makerService;

	@InitBinder("maker")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new MakerValidator(makerService));
	}

	@ModelAttribute("maker")
	public Maker getForm() {
		return new Maker();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("makers", makerService.findAll());
		return "admin-maker";
	}

	@PostMapping
	public String save(@ModelAttribute("maker") @Valid Maker maker,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		makerService.save(maker);
		status.setComplete();
		return "redirect:/admin/maker";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("maker", makerService.findOne(id));
		show(model);
		return "admin-maker";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		makerService.delete(id);
		return "redirect:/admin/maker";
	}

}
