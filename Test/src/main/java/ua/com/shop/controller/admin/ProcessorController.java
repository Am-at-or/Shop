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

import ua.com.shop.editor.NumberOfCoresEditor;
import ua.com.shop.editor.ProcessorMakerEditor;
import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.NumberOfCoresService;
import ua.com.shop.service.ProcessorMakerService;
import ua.com.shop.service.ProcessorService;

@Controller
@RequestMapping("/admin/processor")
@SessionAttributes("processor")
public class ProcessorController {

	@Autowired
	private ProcessorService processorService;

	@Autowired
	private ProcessorMakerService processorMakerService;

	@Autowired
	private NumberOfCoresService numberOfCoresService;

	@InitBinder("processor")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(ProcessorMaker.class,
				new ProcessorMakerEditor(processorMakerService));
		binder.registerCustomEditor(NumberOfCores.class,
				new NumberOfCoresEditor(numberOfCoresService));
	}

	@ModelAttribute("processor")
	public Processor getForm() {
		return new Processor();
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("processormakers", processorMakerService.findAll());
		model.addAttribute("numberofcoress", numberOfCoresService.findAll());
		return "admin-processor";
	}

	@PostMapping
	public String save(@ModelAttribute("processor") Processor processor,
			SessionStatus status) {
		processorService.save(processor);
		status.setComplete();
		return "redirect:/admin/processor";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("processor", processorService.findOne(id));
		show(model);
		return "admin-processor";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		processorService.delete(id);
		return "redirect:/admin/processor";
	}

}
