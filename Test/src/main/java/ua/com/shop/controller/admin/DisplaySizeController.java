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

import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;
import ua.com.shop.validator.DisplaySizeValidator;

@Controller
@RequestMapping("/admin/displaysize")
@SessionAttributes("displaysize")
public class DisplaySizeController {

	@Autowired
	private DisplaySizeService displaySizeService;

	@InitBinder("displaysize")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplaySizeValidator(displaySizeService));
	}

	@ModelAttribute("displaysize")
	public DisplaySize getForm() {
		return new DisplaySize();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displaysizes", displaySizeService.findAll());
		return "admin-displaysize";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displaysize") @Valid DisplaySize displaySize,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		displaySizeService.save(displaySize);
		status.setComplete();
		return "redirect:/admin/displaysize";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displaysize", displaySizeService.findOne(id));
		show(model);
		return "admin-displaysize";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displaySizeService.delete(id);
		return "redirect:/admin/displaysize";
	}

}
