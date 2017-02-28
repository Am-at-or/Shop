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

import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;
import ua.com.shop.validator.ProcessorMakerValidator;

@Controller
@RequestMapping("/admin/processormaker")
@SessionAttributes("processormaker")
public class ProcessorMakerController {

	@Autowired
	private ProcessorMakerService processorMakerService;

	@InitBinder("processormaker")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new ProcessorMakerValidator(processorMakerService));
	}

	@ModelAttribute("processormaker")
	public ProcessorMaker getForm() {
		return new ProcessorMaker();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("processormakers", processorMakerService.findAll());
		return "admin-processormaker";
	}

	@PostMapping
	public String save(
			@ModelAttribute("processormaker") @Valid ProcessorMaker processorMaker,
			BindingResult br, Model model, SessionStatus status) {
		if (br.hasErrors()) {
			return show(model);
		}
		processorMakerService.save(processorMaker);
		status.setComplete();
		return "redirect:/admin/processormaker";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("processormaker", processorMakerService.findOne(id));
		show(model);
		return "admin-processormaker";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		processorMakerService.delete(id);
		return "redirect:/admin/processormaker";
	}

}
