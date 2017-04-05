package ua.com.shop.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
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
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.User;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.service.MakerService;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.service.OrdersService;
import ua.com.shop.service.PhoneService;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.service.UserService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.UserValidator;

@Controller
@SessionAttributes("order")
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

	@Autowired
	private OrdersService ordersService;
	
	@InitBinder("user")
	protected void bind1(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}

	@ModelAttribute("order")
	public Orders getOrders() {
		return new Orders();
	}

	@ModelAttribute("filter")
	public PhoneFilter getFilter() {
		return new PhoneFilter();
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

	@PostMapping("/addtocart/{id}")
	public String addToCart(Model model, @PageableDefault Pageable pageable,
			@PathVariable int id, @ModelAttribute("order") Orders order,
			@ModelAttribute("filter") PhoneFilter filter) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		order.setUser(user);
		Phone phone = phoneService.findOne(id);
		if (order.getPhones() == null)
			order.setPhones(new ArrayList<Phone>());
		if (!order.getPhones().contains(phone))
			order.getPhones().add(phone);
		return show(model, pageable, order, filter);
	}

	@PostMapping("/deletefromcart/{id}")
	public String deleteFromCart(Model model, @PathVariable int id,
			@ModelAttribute("order") Orders order) {
		order.getPhones().remove(phoneService.findOne(id));
		return "redirect:/shoppingcart";
	}

	@RequestMapping("/shoppingcart")
	public String shoppingcart(Model model,
			@ModelAttribute("order") Orders order) {
		model.addAttribute("qwer", order.getPhones());
		return "user-shoppingcart";
	}

	@GetMapping("/makeorder")
	public String makeOrder(@ModelAttribute("order") Orders order,
			SessionStatus status) {
		if (order.getPhones() != null && !order.getPhones().isEmpty())
			ordersService.save(order);
		status.setComplete();
		return "redirect:/";
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
		Phone phone = phoneService.findOne(id);
		List<Phone> phones = phoneService.findByMaker(phone.getMaker()
				.getName());
		phones.remove(phone);
		model.addAttribute("phone", phone);
		model.addAttribute("phones", phones);
		return "user-phone";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult br) {
		if (br.hasErrors())
			return "user-registration";
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("order") Orders order) {
		return "user-login";
	}

	@RequestMapping(value = "/human")
	public String people() {
		return "user-people";
	}

	@RequestMapping(value = "/admin/color")
	public String color() {
		return "admin-color";
	}

}
