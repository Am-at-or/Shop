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

	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}

	@ModelAttribute("processormaker")
	public ProcessorMaker getForm() {
		return new ProcessorMaker();
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page",
				processorMakerService.findAll(pageable, filter));
		return "admin-processormaker";
	}

	@PostMapping
	public String save(
			@ModelAttribute("processormaker") @Valid ProcessorMaker processorMaker,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		if (br.hasErrors()) {
			return show(model, pageable, filter);
		}
		processorMakerService.save(processorMaker);
		status.setComplete();
		return "redirect:/admin/processormaker" + getParams(pageable, filter);
	}

	@GetMapping("/cancel")
	public String cancel(
			@ModelAttribute("processormaker") ProcessorMaker processorMaker,
			SessionStatus status, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/processormaker" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("processormaker", processorMakerService.findOne(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") SimpleFilter filter) {
		processorMakerService.delete(id);
		return "redirect:/admin/processormaker" + getParams(pageable, filter);
	}

}
