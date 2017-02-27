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

import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;

@Controller
@RequestMapping("/admin/osname")
@SessionAttributes("osname")
public class OSNameController {

	@Autowired
	private OSNameService osNameService;

	@ModelAttribute("osname")
	public OSName getForm() {
		return new OSName();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("osnames", osNameService.findAll());
		return "admin-osname";
	}

	@PostMapping
	public String save(@ModelAttribute("osname") OSName osName,
			SessionStatus status) {
		osNameService.save(osName);
		status.setComplete();
		return "redirect:/admin/osname";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("osname", osNameService.findOne(id));
		show(model);
		return "admin-osname";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		osNameService.delete(id);
		return "redirect:/admin/osname";
	}

}
