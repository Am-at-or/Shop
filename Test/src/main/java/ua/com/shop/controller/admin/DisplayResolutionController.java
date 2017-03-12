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

import ua.com.shop.dto.filter.DisplayResolutionFilter;
import ua.com.shop.dto.form.DisplayResolutionForm;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.DisplayValidator;

@Controller
@RequestMapping("/admin/displayresolution")
@SessionAttributes("displayresolution")
public class DisplayResolutionController {

	@Autowired
	private DisplayResolutionService displayService;

	@InitBinder("displayresolution")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new DisplayValidator(displayService));
	}

	@ModelAttribute("filter")
	public DisplayResolutionFilter getFilter() {
		return new DisplayResolutionFilter();
	}

	@ModelAttribute("displayresolution")
	public DisplayResolutionForm getForm() {
		return new DisplayResolutionForm();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayResolutionFilter filter) {
		model.addAttribute("page", displayService.findAll(pageable, filter));
		return "admin-displayresolution";
	}

	@PostMapping
	public String save(
			@ModelAttribute("displayresolution") @Valid DisplayResolutionForm displayForm,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayResolutionFilter filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		displayService.save(displayForm);
		status.setComplete();
		return "redirect:/admin/displayresolution" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayResolutionFilter filter) {
		model.addAttribute("displayresolution", displayService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayResolutionFilter filter) {
		displayService.delete(id);
		return "redirect:/admin/displayresolution" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, DisplayResolutionFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMinWidth().isEmpty()) {
			buffer.append("&minwidth=");
			buffer.append(filter.getMinWidth());
		}
		if (!filter.getMaxWidth().isEmpty()) {
			buffer.append("&maxwidth=");
			buffer.append(filter.getMaxWidth());
		}
		if (!filter.getMinHeight().isEmpty()) {
			buffer.append("&minheight=");
			buffer.append(filter.getMinHeight());
		}
		if (!filter.getMaxHeight().isEmpty()) {
			buffer.append("&maxheight=");
			buffer.append(filter.getMaxHeight());
		}
		return buffer.toString();
	}

}
