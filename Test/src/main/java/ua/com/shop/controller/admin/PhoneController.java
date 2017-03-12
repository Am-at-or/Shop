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

import ua.com.shop.dto.filter.PhoneFilter;
import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.DisplayResolutionEditor;
import ua.com.shop.editor.MakerEditor;
import ua.com.shop.editor.OperatingSystemEditor;
import ua.com.shop.editor.ProcessorEditor;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Processor;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.service.MakerService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.service.PhoneService;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.PhoneValidator;

@Controller
@RequestMapping("/admin/phone")
@SessionAttributes("phone")
public class PhoneController {

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

	@InitBinder("phone")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Maker.class, new MakerEditor(makerService));
		binder.registerCustomEditor(DisplayResolution.class,
				new DisplayResolutionEditor(displayResolutionService));
		binder.registerCustomEditor(Processor.class, new ProcessorEditor(
				processorService));
		binder.registerCustomEditor(OperatingSystem.class,
				new OperatingSystemEditor(operatingSystemService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.setValidator(new PhoneValidator(phoneService));
	}

	@ModelAttribute("filter")
	public PhoneFilter getFilter() {
		return new PhoneFilter();
	}

	@ModelAttribute("phone")
	public PhoneForm getForm() {
		return new PhoneForm();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") PhoneFilter filter) {
		model.addAttribute("page", phoneService.findAll(pageable, filter));
		model.addAttribute("makers", makerService.findAll());
		model.addAttribute("displayresolutions",
				displayResolutionService.findAll());
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		model.addAttribute("colors", colorService.findAll());
		return "admin-phone";
	}

	@PostMapping
	public String save(@ModelAttribute("phone") @Valid PhoneForm phoneForm,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") PhoneFilter filter) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		phoneService.save(phoneForm);
		status.setComplete();
		return "redirect:/admin/phone" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") PhoneFilter filter) {
		model.addAttribute("phone", phoneService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") PhoneFilter filter) {
		phoneService.delete(id);
		return "redirect:/admin/phone" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, PhoneFilter filter) {
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if (!filter.getMakerIds().isEmpty()) {
			for (Integer id : filter.getMakerIds()) {
				buffer.append("&makerIds=");
				buffer.append(id);
			}
		}
		if (!filter.getModelFilter().isEmpty()) {
			buffer.append("&modelFilter=");
			buffer.append(filter.getModelFilter());
		}
		if (!filter.getMinPrice().isEmpty()) {
			buffer.append("&minPrice=");
			buffer.append(filter.getMinPrice());
		}
		if (!filter.getMaxPrice().isEmpty()) {
			buffer.append("&maxPrice=");
			buffer.append(filter.getMaxPrice());
		}
		if (!filter.getMinDisplayValue().isEmpty()) {
			buffer.append("&minDisplayValue=");
			buffer.append(filter.getMinDisplayValue());
		}
		if (!filter.getMaxDisplayValue().isEmpty()) {
			buffer.append("&maxDisplayValue=");
			buffer.append(filter.getMaxDisplayValue());
		}
		if (!filter.getDisplayResolutionIds().isEmpty()) {
			for (Integer id : filter.getDisplayResolutionIds()) {
				buffer.append("&displayResolutionIds=");
				buffer.append(id);
			}
		}
		if (!filter.getMinPrimaryCamera().isEmpty()) {
			buffer.append("&minPrimaryCamera=");
			buffer.append(filter.getMinPrimaryCamera());
		}
		if (!filter.getMaxPrimaryCamera().isEmpty()) {
			buffer.append("&maxPrimaryCamera=");
			buffer.append(filter.getMaxPrimaryCamera());
		}
		if (!filter.getMinSecondaryCamera().isEmpty()) {
			buffer.append("&minSecondaryCamera=");
			buffer.append(filter.getMinSecondaryCamera());
		}
		if (!filter.getMaxSecondaryCamera().isEmpty()) {
			buffer.append("&maxSecondaryCamera=");
			buffer.append(filter.getMaxSecondaryCamera());
		}
		if (!filter.getProcessorIds().isEmpty()) {
			for (Integer id : filter.getProcessorIds()) {
				buffer.append("&processorIds=");
				buffer.append(id);
			}
		}
		if (!filter.getMinRam().isEmpty()) {
			buffer.append("&minRam=");
			buffer.append(filter.getMinRam());
		}
		if (!filter.getMaxRam().isEmpty()) {
			buffer.append("&maxRam=");
			buffer.append(filter.getMaxRam());
		}
		if (!filter.getMinInternal().isEmpty()) {
			buffer.append("&minInternal=");
			buffer.append(filter.getMinInternal());
		}
		if (!filter.getMaxInternal().isEmpty()) {
			buffer.append("&maxInternal=");
			buffer.append(filter.getMaxInternal());
		}
		if (!filter.getMinCard().isEmpty()) {
			buffer.append("&minCard=");
			buffer.append(filter.getMinCard());
		}
		if (!filter.getMaxCard().isEmpty()) {
			buffer.append("&maxCard=");
			buffer.append(filter.getMaxCard());
		}
		if (!filter.getNumberOfSimCardsFilter().isEmpty()) {
			buffer.append("&numberOfSimCardsFilter=");
			buffer.append(filter.getNumberOfSimCardsFilter());
		}
		if (!filter.getOperatingSystemIds().isEmpty()) {
			for (Integer id : filter.getOperatingSystemIds()) {
				buffer.append("&operatingSystemIds=");
				buffer.append(id);
			}
		}
		if (!filter.getMinBattery().isEmpty()) {
			buffer.append("&minBattery=");
			buffer.append(filter.getMinBattery());
		}
		if (!filter.getMaxBattery().isEmpty()) {
			buffer.append("&maxBattery=");
			buffer.append(filter.getMaxBattery());
		}
		if (!filter.getColorIds().isEmpty()) {
			for (Integer id : filter.getColorIds()) {
				buffer.append("&colorIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}

}
