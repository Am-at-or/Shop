package ua.com.shop.controller.admin;

import static ua.com.shop.util.ParamBuilder.getParams;

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

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;
import ua.com.shop.validator.OSNameValidator;

@Controller
@RequestMapping("/admin/osname")
@SessionAttributes("osname")
public class OSNameController {

	@Autowired
	private OSNameService osNameService;

	@InitBinder("osname")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new OSNameValidator(osNameService));
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@ModelAttribute("osname")
	public OSName getForm() {
		return new OSName();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", osNameService.findAll(pageable, filter));
		return "admin-osname";
	}

	@PostMapping
	public String save(@ModelAttribute("osname") @Valid OSName osName,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		osNameService.save(osName);
		status.setComplete();
		return "redirect:/admin/osname" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(@ModelAttribute("osname") OSName osName,
			SessionStatus status, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/osname" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("osname", osNameService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		osNameService.delete(id);
		return "redirect:/admin/osname" + getParams(pageable, filter);
	}

}
