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

import ua.com.shop.dto.form.InternalMemoryForm;
import ua.com.shop.service.InternalMemoryService;
import ua.com.shop.validator.InternalMemoryValidator;

@Controller
@RequestMapping("/admin/internalmemory")
@SessionAttributes("internalmemory")
public class InternalMemoryController {

	@Autowired
	private InternalMemoryService internalMemoryService;

	@InitBinder("internalmemory")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new InternalMemoryValidator(internalMemoryService));
	}

	@ModelAttribute("internalmemory")
	public InternalMemoryForm getForm() {
		return new InternalMemoryForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("internalmemories", internalMemoryService.findAll());
		return "admin-internalmemory";
	}

	@PostMapping
	public String save(
			@ModelAttribute("internalmemory") @Valid InternalMemoryForm internalMemoryForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		internalMemoryService.save(internalMemoryForm);
		status.setComplete();
		return "redirect:/admin/internalmemory";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("internalmemory", internalMemoryService.findForm(id));
		show(model);
		return "admin-internalmemory";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		internalMemoryService.delete(id);
		return "redirect:/admin/internalmemory";
	}

}
