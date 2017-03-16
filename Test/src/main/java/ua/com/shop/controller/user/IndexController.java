package ua.com.shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
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

import ua.com.shop.dto.filter.PhoneFilter;
import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.DisplayResolutionEditor;
import ua.com.shop.editor.MakerEditor;
import ua.com.shop.editor.OperatingSystemEditor;
import ua.com.shop.editor.ProcessorEditor;
import ua.com.shop.editor.UserEditor;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.User;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.service.MakerService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.service.PhoneService;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.service.UserService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.PhoneValidator;

@Controller
@SessionAttributes({ "phone", "order" })
@RequestMapping("/")
public class IndexController {
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

	@Autowired
	private UserService userService;

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

	@InitBinder("order")
	protected void bind2(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}

	@ModelAttribute("order")
	public Orders getOrders() {
		return new Orders();
	}

	@ModelAttribute("filter")
	public PhoneFilter getFilter() {
		return new PhoneFilter();
	}

	@ModelAttribute("phone")
	public PhoneForm getForm() {
		return new PhoneForm();
	}

	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("order") Orders order,
			@ModelAttribute("filter") PhoneFilter filter) {
		model.addAttribute("ord", order);
		model.addAttribute("page", phoneService.findAll(pageable, filter));
		model.addAttribute("makers", makerService.findAll());
		model.addAttribute("displayresolutions",
				displayResolutionService.findAll());
		model.addAttribute("processors", processorService.findAll());
		model.addAttribute("operatingsystems", operatingSystemService.findAll());
		model.addAttribute("colors", colorService.findAll());
		return "user-index";
	}

	@PostMapping("/addtopackage/{id}")
	public String addToPackage(Model model, @PageableDefault Pageable pageable,
			@PathVariable int id, @ModelAttribute("order") Orders order,
			@ModelAttribute("filter") PhoneFilter filter) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		order.setUser(user);
		Phone phone = phoneService.findOne(id);
		if (order.getPhones() == null)
			order.setPhones(new ArrayList<Phone>());
		order.getPhones().add(phone);
		return show(model, pageable, order, filter);
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

	@GetMapping
	public String index(Principal principal, Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("order") Orders order,
			@ModelAttribute("filter") PhoneFilter filter) {
		if (principal != null) {
			System.out.println(principal.getName());
			SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
		}
		return show(model, pageable, order, filter);
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin-admin";
	}

	@RequestMapping("/shoppingcart")
	public String shoppingcart(@ModelAttribute("order") Orders order) {
		return "user-shoppingcart";
	}

	@RequestMapping("/faq")
	public String faq() {
		return "user-faq";
	}

	@RequestMapping("/about")
	public String about() {
		return "user-about";
	}

	@RequestMapping("/delivery")
	public String delivery() {
		return "user-delivery";
	}

	@RequestMapping("/contacts")
	public String contacts() {
		return "user-contacts";
	}

	@RequestMapping("/phone/{id}")
	public String phone(@PathVariable int id, Model model) {
		model.addAttribute("phone", phoneService.findOne(id));
		return "user-phone";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("order") Orders order) {
		return "user-login";
	}

}
