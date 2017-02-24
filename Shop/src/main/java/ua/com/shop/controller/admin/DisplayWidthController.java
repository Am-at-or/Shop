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

import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayWidthService;

@Controller
@RequestMapping("/admin/displaywidth")
@SessionAttributes("displaywidth")
public class DisplayWidthController {

	@Autowired
	private DisplayWidthService displayWidthService;

	@ModelAttribute("displaywidth")
	public DisplayWidth getForm() {
		return new DisplayWidth();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("displaywidths", displayWidthService.findAll());
		return "admin-displaywidth";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displaywidth") DisplayWidth displayWidth,
			SessionStatus status) {
		displayWidthService.save(displayWidth);
		status.setComplete();
		return "redirect:/admin/displaywidth";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("displaywidth", displayWidthService.findOne(id));
		show(model);
		return "admin-displaywidth";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		displayWidthService.delete(id);
		return "redirect:/admin/displaywidth";
	}

}
