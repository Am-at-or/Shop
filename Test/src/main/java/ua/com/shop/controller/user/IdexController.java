package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.PhoneService;
import ua.com.shop.service.RatingService;

@Controller
public class IdexController {
	@Autowired
	private PhoneService mobilePhoneService;
	@Autowired
	private RatingService makerService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("phones", mobilePhoneService.findAll());
		return "user-index";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin-admin";
	}
	
	@RequestMapping("/faq")
	public String faq() {
		return "user-faq";
	}

	@RequestMapping("/about")
	public String about() {
		return "user-about";
	}

	@RequestMapping("/delivery")
	public String delivery() {
		return "user-delivery";
	}
	
	@RequestMapping("/contacts")
	public String contacts() {
		return "user-contacts";
	}

	@RequestMapping("/phone/{id}")
	public String phone(@PathVariable int id, Model model) {
		model.addAttribute("phone", mobilePhoneService.findOne(id));
		return "user-phone";
	}

}
