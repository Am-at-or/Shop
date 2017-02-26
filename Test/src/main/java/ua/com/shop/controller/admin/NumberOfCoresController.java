package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.service.NumberOfCoresService;

@Controller
@RequestMapping("/admin/numberofcores")
@SessionAttributes("numberofcores")
public class NumberOfCoresController {

	@Autowired
	private NumberOfCoresService numberOfCoresService;

	@ModelAttribute("numberofcores")
	public NumberOfCores getForm() {
		return new NumberOfCores();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("numberofcoress", numberOfCoresService.findAll());
		return "admin-numberofcores";
	}

	@PostMapping
	public String save(
			@ModelAttribute("numberofcores") NumberOfCores numberOfCores,
			SessionStatus status) {
		numberOfCoresService.save(numberOfCores);
		status.setComplete();
		return "redirect:/admin/numberofcores";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("numberofcores", numberOfCoresService.findOne(id));
		show(model);
		return "admin-numberofcores";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		numberOfCoresService.delete(id);
		return "redirect:/admin/numberofcores";
	}

}
