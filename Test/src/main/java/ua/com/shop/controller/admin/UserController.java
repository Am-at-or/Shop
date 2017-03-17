package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.UserFilter;
import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.UserValidator;

@Controller
@RequestMapping("/admin/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}

	@ModelAttribute("filter")
	public UserFilter getFilter() {
		return new UserFilter();
	}

	@ModelAttribute("user")
	public User getForm() {
		return new User();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") UserFilter filter) {
		model.addAttribute("page", userService.findAll(pageable, filter));
		return "admin-user";
	}

	@PostMapping
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UserFilter filter) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		userService.save(user);
		status.setComplete();
		return "redirect:/admin/user" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UserFilter filter) {
		model.addAttribute("user", userService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") UserFilter filter) {
		userService.delete(id);
		return "redirect:/admin/user" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, UserFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getEmailFilter().isEmpty()) {
			buffer.append("&emailFilter=");
			buffer.append(filter.getEmailFilter());
		}
		if (!filter.getLoginFilter().isEmpty()) {
			buffer.append("&loginFilter=");
			buffer.append(filter.getLoginFilter());
		}
		if (!filter.getPhoneNumberFilter().isEmpty()) {
			buffer.append("&phoneNumberFilter=");
			buffer.append(filter.getPhoneNumberFilter());
		}
		if (!filter.getFirstNameFilter().isEmpty()) {
			buffer.append("&firstNameFilter=");
			buffer.append(filter.getFirstNameFilter());
		}
		if (!filter.getLastNameFilter().isEmpty()) {
			buffer.append("&lastNameFilter=");
			buffer.append(filter.getLastNameFilter());
		}
		return buffer.toString();
	}

}
