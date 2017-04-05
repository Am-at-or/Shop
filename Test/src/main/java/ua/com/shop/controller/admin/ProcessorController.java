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

import ua.com.shop.dto.filter.ProcessorFilter;
import ua.com.shop.dto.form.ProcessorForm;
import ua.com.shop.editor.ProcessorMakerEditor;
import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.ProcessorValidator;

@Controller
@RequestMapping("/admin/processor")
@SessionAttributes("processor")
public class ProcessorController {

	@Autowired
	private ProcessorService processorService;

	@Autowired
	private ProcessorMakerService processorMakerService;

	@InitBinder("processor")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(ProcessorMaker.class,
				new ProcessorMakerEditor(processorMakerService));
		binder.setValidator(new ProcessorValidator(processorService));
	}

	@ModelAttribute("filter")
	public ProcessorFilter getFilter() {
		return new ProcessorFilter();
	}

	@ModelAttribute("processor")
	public ProcessorForm getForm() {
		return new ProcessorForm();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProcessorFilter filter) {
		model.addAttribute("page", processorService.findAll(pageable, filter));
		model.addAttribute("processormakers", processorMakerService.findAll());
		return "admin-processor";
	}

	@PostMapping
	public String save(
			@ModelAttribute("processor") @Valid ProcessorForm processorForm,
			BindingResult br, Model model, SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProcessorFilter filter) {
		if (br.hasErrors())
			return show(model, pageable, filter);
		processorService.save(processorForm);
		status.setComplete();
		return "redirect:/admin/processor" + getParams(pageable, filter);
	}
	
	@GetMapping("/cancel")
	public String cancel(@ModelAttribute("processor") ProcessorForm processorForm,
			SessionStatus status, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProcessorFilter filter) {
		status.setComplete();
		return "redirect:/admin/processor" + getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProcessorFilter filter) {
		model.addAttribute("processor", processorService.findForm(id));
		return show(model, pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") ProcessorFilter filter) {
		processorService.delete(id);
		return "redirect:/admin/processor" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, ProcessorFilter filter) {
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
		if (!filter.getMinFrequency().isEmpty()) {
			buffer.append("&minFrequency=");
			buffer.append(filter.getMinFrequency());
		}
		if (!filter.getMaxFrequency().isEmpty()) {
			buffer.append("&maxFrequency=");
			buffer.append(filter.getMaxFrequency());
		}
		if (!filter.getNumberOfCoresFilter().isEmpty()) {
			buffer.append("&numberOfCoresFilter=");
			buffer.append(filter.getNumberOfCoresFilter());
		}
		return buffer.toString();
	}

}
