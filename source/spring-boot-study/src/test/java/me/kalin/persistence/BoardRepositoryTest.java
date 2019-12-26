package me.kalin.persistence;

import lombok.extern.slf4j.Slf4j;
import me.kalin.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardRepositoryTest {

	@Autowired
	private BoardRepo boardRepository;

	@Test
	public void insert() {
		Board board = new Board();
		board.setTitle("title sample");
		board.setContent("content sample");
		board.setWriter("user00");

		boardRepository.save(board);
	}

	@Test
	public void read() {
		boardRepository.findById(1L).ifPresent((board) -> {
			log.info(board.toString());
		});
	}

	@Test
	public void update() {
		System.out.println("Read First ........");
		Board board = boardRepository.findById(1L).orElseThrow(NullPointerException::new);
		System.out.println(board.toString());

		System.out.println("Update Title .........");
		board.setTitle("수정된 제목");

		System.out.println("Call save() ..........");
		boardRepository.save(board);
	}

	@Test
	public void delete() {
		log.info("delete entity");
		boardRepository.deleteById(1L);
	}

	@Test
	public void insertBoardSample() {
		IntStream.range(0, 200).forEach((i) -> {
			Board board = new Board();
			board.setTitle("title...." + i);
			board.setContent("content ..." + i);
			board.setWriter("user0" + (i % 10));
			boardRepository.save(board);
		});
	}

	@Test
	public void find_by_test() {
		boardRepository.findByWriter("user00").forEach(board -> {
			log.info(board.toString());
		});
	}

	@Test
	public void like_test() {
		boardRepository.findByWriterContaining("04").forEach(board -> {
			log.info(board.toString());
		});
	}

	@Test
	public void or_test() {
		boardRepository.findByWriterOrContent("user04", "0").forEach(board -> {
			log.info(board.toString());
		});
	}

	@Test
	public void greaterThan_test() {
		boardRepository.findByTitleContainingAndBnoGreaterThan("4", 40L).forEach(board -> {
			log.info(board.toString());
		});
	}

	@Test
	public void orderByTest() {
		boardRepository.findByBnoGreaterThanOrderByBnoDesc(50l).forEach(board -> {
			log.info(board.toString());
		});
	}

}
