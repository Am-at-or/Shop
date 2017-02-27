package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.DisplayEditor;
import ua.com.shop.editor.MakerEditor;
import ua.com.shop.editor.OperatingSystemEditor;
import ua.com.shop.editor.ProcessorEditor;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DisplayService;
import ua.com.shop.service.MakerService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.service.PhoneService;
import ua.com.shop.service.ProcessorService;

@Controller
@RequestMapping("/admin/phone")
@SessionAttributes("phone")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@Autowired
	private MakerService makerService;

	@Autowired
	private DisplayService displayService;

	@Autowired
	private ProcessorService processorService;

	@Autowired
	private OperatingSystemService operatingSystemService;

	@Autowired
	private ColorService colorService;

	@InitBinder("phone")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Maker.class, new MakerEditor(makerService));
		binder.registerCustomEditor(Display.class, new DisplayEditor(
				displayService));
		binder.registerCustomEditor(Processor.class, new ProcessorEditor(
				processorService));
		binder.registerCustomEditor(OperatingSystem.class,
				new OperatingSystemEditor(operatingSystemService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
	}

	@ModelAttribute("phone")
	public Phone getForm() {
		return new Phone();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("phones", phoneService.findAll());
		model.addAttribute("makers", makerService.findAll());
		model.addAttribute("displays", displayService.findAll());
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		model.addAttribute("colors", colorService.findAll());
		return "admin-phone";
	}

	@PostMapping
	public String save(@ModelAttribute("phone") Phone phone,
			SessionStatus status) {
		phoneService.save(phone);
		status.setComplete();
		return "redirect:/admin/phone";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("phone", phoneService.findOne(id));
		show(model);
		return "admin-phone";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		phoneService.delete(id);
		return "redirect:/admin/phone";
	}

}
