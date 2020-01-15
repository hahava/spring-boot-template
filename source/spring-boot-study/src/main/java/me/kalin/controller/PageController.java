package me.kalin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@GetMapping("/index")
	public void index(Model model) {
		model.addAttribute("welcome", "hello world");
	}

	@GetMapping("/boardWriter")
	public void boardWriter() {
	}

	@GetMapping("/boardList")
	public String boardList() {
		return "boardList";
	}

}
