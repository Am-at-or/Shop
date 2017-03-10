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

import ua.com.shop.dto.filter.SimpleFilterDecimal;
import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.service.DisplayValueService;
import ua.com.shop.validator.DisplayValueValidator;

@Controller
@RequestMapping("/admin/displayvalue")
@SessionAttributes("displaysize")
public class DisplayValueController {

	@Autowired
	private DisplayValueService displayValueService;

	@InitBinder("displayvalue")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplayValueValidator(displayValueService));
	}

	@ModelAttribute("filter")
	public SimpleFilterDecimal getFilter() {
		return new SimpleFilterDecimal();
	}

	@ModelAttribute("displayvalue")
	public DisplayValueForm getForm() {
		return new DisplayValueForm();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		model.addAttribute("page",
				displayValueService.findAll(pageable, filter));
		return "admin-displayvalue";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displayvalue") @Valid DisplayValueForm displayValueForm,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		displayValueService.save(displayValueForm);
		status.setComplete();
		return "redirect:/admin/displayvalue" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		model.addAttribute("displayvalue", displayValueService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilterDecimal filter) {
		displayValueService.delete(id);
		return "redirect:/admin/displayvalue" + getParams(pageable, filter);
	}

}
