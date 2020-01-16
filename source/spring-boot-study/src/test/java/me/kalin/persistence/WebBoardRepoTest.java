package me.kalin.persistence;

import lombok.extern.java.Log;
import me.kalin.domain.WebBoard;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log
@Commit
public class WebBoardRepoTest {

	@Autowired
	private WebBoardRepository webBoardRepository;

	@Ignore
	@Test
	public void insertDummyDatas() {
		IntStream.range(1, 301).forEach(i -> {
			WebBoard webBoard = new WebBoard();
			webBoard.setTitle("Sample board..." + i);
			webBoard.setContent("Sample content ...." + i);
			webBoard.setWriter("user0" + i);
			webBoardRepository.save(webBoard);
		});
	}

	@Test
	public void selectWebBoardList() {
		Pageable pageable = PageRequest.of(1, 10, Sort.by("no").descending());
		Page<WebBoard> allWebBoards = webBoardRepository.findAll(pageable);
		allWebBoards.forEach(webBoard -> {
			System.out.println(webBoard.getContent());
		});
	}

	@Test
	public void selectWebBoardListLikeContent() {
		Pageable pageable = PageRequest.of(1, 10);
		Page<WebBoard> page = webBoardRepository.findByContentContaining("8", pageable);
		page.forEach(webBoard -> {
			log.info(webBoard.toString());
		});
	}

}
