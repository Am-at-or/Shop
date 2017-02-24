package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Processor;
import ua.com.shop.service.ProcessorService;

@Controller
@RequestMapping("/admin/processor")
public class ProcessorController {

	@Autowired
	private ProcessorService processorService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("processors", processorService.findAll());
		return "admin-processor";
	}

	@PostMapping
	public String save(@RequestParam String name, @RequestParam int frequency) {
		Processor processor = new Processor(name, frequency);
		processorService.save(processor);
		return "redirect:/admin/processor";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		processorService.delete(id);
		return "redirect:/admin/processor";
	}

}
