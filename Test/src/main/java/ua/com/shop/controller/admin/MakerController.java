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

import ua.com.shop.entity.Maker;
import ua.com.shop.service.MakerService;

@Controller
@RequestMapping("/admin/maker")
@SessionAttributes("maker")
public class MakerController {

	@Autowired
	private MakerService makerService;

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
	public String save(@ModelAttribute("maker") Maker maker,
			SessionStatus status) {
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
