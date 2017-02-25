package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.PhoneService;

@Controller
@RequestMapping("/admin/phone")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("phones", phoneService.findAll());
		return "admin-phone";
	}


	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		phoneService.delete(id);
		return "redirect:/admin/phone";
	}

}
