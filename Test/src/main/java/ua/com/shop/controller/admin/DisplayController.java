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

import ua.com.shop.dto.filter.DisplayFilter;
import ua.com.shop.editor.DisplayHeightEditor;
import ua.com.shop.editor.DisplayValueEditor;
import ua.com.shop.editor.DisplayTechnologyEditor;
import ua.com.shop.editor.DisplayWidthEditor;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplayValue;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayHeightService;
import ua.com.shop.service.DisplayService;
import ua.com.shop.service.DisplayValueService;
import ua.com.shop.service.DisplayTechnologyService;
import ua.com.shop.service.DisplayWidthService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.DisplayValidator;

@Controller
@RequestMapping("/admin/display")
@SessionAttributes("display")
public class DisplayController {

	@Autowired
	private DisplayService displayService;

	@Autowired
	private DisplayValueService displayValueService;

	@Autowired
	private DisplayTechnologyService displayTechnologyService;

	@Autowired
	private DisplayWidthService displayWidthService;

	@Autowired
	private DisplayHeightService displayHeightService;

	@InitBinder("display")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(DisplayValue.class, new DisplayValueEditor(
				displayValueService));
		binder.registerCustomEditor(DisplayWidth.class, new DisplayWidthEditor(
				displayWidthService));
		binder.registerCustomEditor(DisplayHeight.class,
				new DisplayHeightEditor(displayHeightService));
		binder.registerCustomEditor(DisplayTechnology.class,
				new DisplayTechnologyEditor(displayTechnologyService));
		binder.setValidator(new DisplayValidator(displayService));
	}

	@ModelAttribute("filter")
	public DisplayFilter getFilter() {
		return new DisplayFilter();
	}

	@ModelAttribute("display")
	public Display getForm() {
		return new Display();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayFilter filter) {
		model.addAttribute("page", displayService.findAll(pageable, filter));
		model.addAttribute("displaywidths", displayWidthService.findAll());
		model.addAttribute("displayheights", displayHeightService.findAll());
		model.addAttribute("displayvalues", displayValueService.findAll());
		model.addAttribute("displaytechnologies",
				displayTechnologyService.findAll());
		return "admin-display";
	}

	@PostMapping
	public String save(@ModelAttribute("display") @Valid Display display,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayFilter filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		displayService.save(display);
		status.setComplete();
		return "redirect:/admin/display" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayFilter filter) {
		model.addAttribute("display", displayService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") DisplayFilter filter) {
		displayService.delete(id);
		return "redirect:/admin/display" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, DisplayFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getDisplayValueIds().isEmpty()) {
			for (Integer id : filter.getDisplayValueIds()) {
				buffer.append("&displayValueIds=");
				buffer.append(id);
			}
		}
		if (!filter.getDisplayWidthIds().isEmpty()) {
			for (Integer id : filter.getDisplayWidthIds()) {
				buffer.append("&displayWidthIds=");
				buffer.append(id);
			}
		}
		if (!filter.getDisplayHeightIds().isEmpty()) {
			for (Integer id : filter.getDisplayHeightIds()) {
				buffer.append("&displayHeightIds=");
				buffer.append(id);
			}
		}
		if (!filter.getDisplayTechnologyIds().isEmpty()) {
			for (Integer id : filter.getDisplayTechnologyIds()) {
				buffer.append("&displayTechnologyIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}

}
