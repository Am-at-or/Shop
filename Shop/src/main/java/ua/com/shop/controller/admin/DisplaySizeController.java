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

import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;

@Controller
@RequestMapping("/admin/displaysize")
@SessionAttributes("displaysize")
public class DisplaySizeController {

	@Autowired
	private DisplaySizeService displaySizeService;

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
	public String save(@ModelAttribute("displaysize") DisplaySize displaySize,
			SessionStatus status) {
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
