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

import ua.com.shop.dto.form.RamForm;
import ua.com.shop.service.RamService;
import ua.com.shop.validator.RamValidator;

@Controller
@RequestMapping("/admin/ram")
@SessionAttributes("ram")
public class RamController {

	@Autowired
	private RamService ramService;

	@InitBinder("ram")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new RamValidator(ramService));
	}

	@ModelAttribute("ram")
	public RamForm getForm() {
		return new RamForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("rams", ramService.findAll());
		return "admin-ram";
	}

	@PostMapping
	public String save(@ModelAttribute("ram") @Valid RamForm ramForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		ramService.save(ramForm);
		status.setComplete();
		return "redirect:/admin/ram";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("ram", ramService.findForm(id));
		show(model);
		return "admin-ram";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ramService.delete(id);
		return "redirect:/admin/ram";
	}

}
