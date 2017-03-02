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

import ua.com.shop.dto.form.DisplayWidthForm;
import ua.com.shop.service.DisplayWidthService;
import ua.com.shop.validator.DisplayWidthValidator;

@Controller
@RequestMapping("/admin/displaywidth")
@SessionAttributes("displaywidth")
public class DisplayWidthController {

	@Autowired
	private DisplayWidthService displayWidthService;

	@InitBinder("displaywidth")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplayWidthValidator(displayWidthService));
	}

	@ModelAttribute("displaywidth")
	public DisplayWidthForm getForm() {
		return new DisplayWidthForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displaywidths", displayWidthService.findAll());
		return "admin-displaywidth";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displaywidth") @Valid DisplayWidthForm displayWidthForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		displayWidthService.save(displayWidthForm);
		status.setComplete();
		return "redirect:/admin/displaywidth";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displaywidth", displayWidthService.findForm(id));
		show(model);
		return "admin-displaywidth";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayWidthService.delete(id);
		return "redirect:/admin/displaywidth";
	}

}
