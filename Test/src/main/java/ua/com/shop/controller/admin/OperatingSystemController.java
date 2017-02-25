package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.service.OperatingSystemService;

@Controller
@RequestMapping("/admin/operatingsystem")
public class OperatingSystemController {

	@Autowired
	private OperatingSystemService operatingSystemService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		return "admin-operatingsystem";
	}

	@PostMapping
	public String save(@RequestParam String name, @RequestParam double version) {
		OperatingSystem operatingSystem = new OperatingSystem(version);
		operatingSystemService.save(operatingSystem);
		return "redirect:/admin/operatingsystem";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		operatingSystemService.delete(id);
		return "redirect:/admin/operatingsystem";
	}

}
