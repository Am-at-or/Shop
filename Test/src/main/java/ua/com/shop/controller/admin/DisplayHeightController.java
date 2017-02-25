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

import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.service.DisplayHeightService;

@Controller
@RequestMapping("/admin/displayheight")
@SessionAttributes("displayheight")
public class DisplayHeightController {
	@Autowired
	private DisplayHeightService displayHeightService;

	@ModelAttribute("displayheight")
	public DisplayHeight getForm() {
		return new DisplayHeight();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displayheights", displayHeightService.findAll());
		return "admin-displayheight";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displayheight") DisplayHeight displayHeight,
			SessionStatus status) {
		displayHeightService.save(displayHeight);
		status.setComplete();
		return "redirect:/admin/displayheight";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displayheight", displayHeightService.findOne(id));
		show(model);
		return "admin-displayheight";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayHeightService.delete(id);
		return "redirect:/admin/displayheight";
	}

}
