package me.kalin.controller;

import me.kalin.domain.WebBoard;
import me.kalin.persistence.WebBoardRepository;
import me.kalin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	private WebBoardRepository webBoardRepository;

	@GetMapping("/")
	public String helloBoot() {
		return "hello Boot!";
	}

	@GetMapping("/boardList")
	public List<WebBoard> board(
		@PageableDefault(
			direction = Sort.Direction.DESC,
			sort = "no",
			size = 10,
			page = 0) Pageable pageable
	) {
		return webBoardRepository.findAll(pageable).getContent();
	}

	@GetMapping("/boardList/se")
	public List<WebBoard> boardSe(PageVO pageVO) {
		Pageable pageable = pageVO.makePageable(0, "no");
		return webBoardRepository.findAll(pageable).getContent();
	}

}
