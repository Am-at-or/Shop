package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.entity.User;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.service.MakerService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.service.PhoneService;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.service.UserService;

@Controller
public class IdexController {
	@Autowired
	private PhoneService phoneService;

	@Autowired
	private MakerService makerService;

	@Autowired
	private DisplayResolutionService displayResolutionService;

	@Autowired
	private ProcessorService processorService;

	@Autowired
	private OperatingSystemService operatingSystemService;

	@Autowired
	private ColorService colorService;

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("phones", phoneService.findAll());
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
		model.addAttribute("phone", phoneService.findOne(id));
		return "user-phone";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "user-login";
	}

}
