package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("users", userService.findAll());
		return "admin-user";
	}

	@PostMapping
	public String save(@RequestParam String login,
			@RequestParam String password, @RequestParam String email,
			@RequestParam int phoneNumber, @RequestParam String firstName,
			@RequestParam String lastName) {
		User user = new User(login, password, email, phoneNumber, firstName,
				lastName);
		userService.save(user);
		return "redirect:/admin/user";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/admin/user";
	}

}
