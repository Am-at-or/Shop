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

import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.service.DisplayValueService;
import ua.com.shop.validator.DisplayValueValidator;

@Controller
@RequestMapping("/admin/displayvalue")
@SessionAttributes("displaysize")
public class DisplaySizeController {

	@Autowired
	private DisplayValueService displayValueService;

	@InitBinder("displayvalue")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplayValueValidator(displayValueService));
	}

	@ModelAttribute("displayvalue")
	public DisplayValueForm getForm() {
		return new DisplayValueForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displayvalues", displayValueService.findAll());
		return "admin-displayvalue";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displayvalue") @Valid DisplayValueForm displayValueForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors())
			return show(model);
		displayValueService.save(displayValueForm);
		status.setComplete();
		return "redirect:/admin/displayvalue";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displayvalue", displayValueService.findForm(id));
		show(model);
		return "admin-displayvalue";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayValueService.delete(id);
		return "redirect:/admin/displayvalue";
	}

}
