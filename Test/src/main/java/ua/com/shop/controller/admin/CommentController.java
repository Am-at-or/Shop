package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Comment;
import ua.com.shop.service.CommentService;

@Controller
@RequestMapping("/admin/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("comments", commentService.findAll());
		return "admin-comment";
	}

	@PostMapping
	public String save(@RequestParam String textComment) {
		Comment comment = new Comment(textComment);
		commentService.save(comment);
		return "redirect:/admin/comment";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		commentService.delete(id);
		return "redirect:/admin/comment";
	}

}
