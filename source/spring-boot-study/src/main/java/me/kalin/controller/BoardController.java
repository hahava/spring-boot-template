package me.kalin.controller;

import lombok.extern.slf4j.Slf4j;
import me.kalin.domain.WebBoard;
import me.kalin.persistence.WebBoardRepository;
import me.kalin.vo.PageMaker;
import me.kalin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	@Autowired
	private WebBoardRepository webBoardRepository;

	@GetMapping("/list")
	public String boardSe(PageVO pageVO, Model model) {
		Pageable pageable = pageVO.makePageable(0, "no");
		PageMaker<WebBoard> webBoardPageMaker = new PageMaker<>(webBoardRepository.findAll(pageable));

		model.addAttribute("isEmpty", webBoardPageMaker.getResult().isEmpty());
		model.addAttribute("page", webBoardPageMaker);

		return "boardList";
	}

}
