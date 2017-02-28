package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.com.shop.dto.form.OperatingSystemForm;
import ua.com.shop.editor.OSNameEditor;
import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.validator.OperatingSystemValidator;

@Controller
@RequestMapping("/admin/operatingsystem")
@SessionAttributes("operatingsystem")
public class OperatingSystemController {

	@Autowired
	private OperatingSystemService operatingSystemService;

	@Autowired
	private OSNameService osNameService;

	@InitBinder("operatingsystem")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(OSName.class, new OSNameEditor(
				osNameService));
		binder.setValidator(new OperatingSystemValidator(operatingSystemService));
	}

	@ModelAttribute("operatingsystem")
	public OperatingSystemForm getForm() {
		return new OperatingSystemForm();
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		model.addAttribute("osnames", osNameService.findAll());
		return "admin-operatingsystem";
	}

	@PostMapping
	public String save(
			@ModelAttribute("operatingsystem") @Valid OperatingSystemForm operatingSystemForm,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors())
			return show(model);
		operatingSystemForm.setVersion(operatingSystemForm.getVersion()
				.replace(",", "."));
		operatingSystemService.save(operatingSystemForm);
		status.setComplete();
		return "redirect:/admin/operatingsystem";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("operatingsystem",
				operatingSystemService.findForm(id));
		show(model);
		return "admin-operatingsystem";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		operatingSystemService.delete(id);
		return "redirect:/admin/operatingsystem";
	}

}
