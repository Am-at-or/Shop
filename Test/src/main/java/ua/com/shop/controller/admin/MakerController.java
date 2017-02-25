package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Maker;
import ua.com.shop.service.MakerService;

@Controller
@RequestMapping("/admin/maker")
public class MakerController {

	@Autowired
	private MakerService makerService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("makers", makerService.findAll());
		return "admin-maker";
	}

	@PostMapping
	public String save(@RequestParam String name) {
		Maker maker = new Maker(name);
		makerService.save(maker);
		return "redirect:/admin/maker";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		makerService.delete(id);
		return "redirect:/admin/maker";
	}

}
