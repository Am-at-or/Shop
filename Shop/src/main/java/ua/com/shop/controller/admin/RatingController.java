package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.entity.Rating;
import ua.com.shop.service.RatingService;

@Controller
@RequestMapping("/admin/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("ratings", ratingService.findAll());
		return "admin-rating";
	}

	@PostMapping
	public String save() {
		Rating rating = new Rating();
		ratingService.save(rating);
		return "redirect:/admin/rating";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ratingService.delete(id);
		return "redirect:/admin/rating";
	}

}
