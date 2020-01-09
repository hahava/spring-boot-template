package me.kalin.persistence;

import lombok.extern.java.Log;
import me.kalin.domain.WebBoard;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
