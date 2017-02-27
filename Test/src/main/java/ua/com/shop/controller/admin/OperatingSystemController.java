package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.OSNameEditor;
import ua.com.shop.entity.OSName;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.service.OSNameService;
import ua.com.shop.service.OperatingSystemService;

@Controller
@RequestMapping("/admin/operatingsystem")
@SessionAttributes("operatingsystem")
public class OperatingSystemController {

	@Autowired
	private OperatingSystemService operatingSystemService;

	@Autowired
	private OSNameService osNameService;

	@InitBinder("operatingsystem")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(OSName.class, new OSNameEditor(
				osNameService));
	}

	@ModelAttribute("operatingsystem")
	public OperatingSystem getForm() {
		return new OperatingSystem();
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		model.addAttribute("osnames", osNameService.findAll());
		return "admin-operatingsystem";
	}

	@PostMapping
	public String save(
			@ModelAttribute("operatingsystem") OperatingSystem operatingSystem,
			SessionStatus status) {
		operatingSystemService.save(operatingSystem);
		status.setComplete();
		return "redirect:/admin/operatingsystem";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("operatingsystem",
				operatingSystemService.findOne(id));
		show(model);
		return "admin-operatingsystem";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		operatingSystemService.delete(id);
		return "redirect:/admin/operatingsystem";
	}

}
