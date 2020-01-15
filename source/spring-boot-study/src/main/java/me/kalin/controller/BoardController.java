package me.kalin.controller;

import me.kalin.domain.WebBoard;
import me.kalin.persistence.WebBoardRepository;
import me.kalin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private WebBoardRepository webBoardRepository;

	@GetMapping("/list")
	public String boardSe(PageVO pageVO, Model model) {
		Pageable pageable = pageVO.makePageable(0, "no");
		model.addAttribute("boardList", webBoardRepository.findAll(pageable).getContent());
		return "boardList";
	}

}
