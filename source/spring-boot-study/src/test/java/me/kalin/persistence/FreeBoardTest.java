package me.kalin.persistence;

import lombok.extern.java.Log;
import me.kalin.domain.FreeBoard;
import me.kalin.domain.FreeBoardReply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class FreeBoardTest {
	@Autowired
	private FreeBoardRepository freeBoardRepository;

	@Autowired
	private FreeBoardReplyRepository freeBoardReplyRepository;

	@Test
	public void insertDummy() {
		IntStream.range(1, 200).forEach(i -> {
			FreeBoard freeBoard = new FreeBoard();
			freeBoard.setTitle("Free Board..." + i);
			freeBoard.setContent("Free Content..." + i);
			freeBoard.setWriter("user" + i % 10);
			freeBoardRepository.save(freeBoard);
		});
	}

	@Test
	@Transactional
	public void insertReply2Way() {
		Optional<FreeBoard> result = freeBoardRepository.findById(199L);
		result.ifPresent(freeBoard -> {
			log.info(freeBoard.toString());
			List<FreeBoardReply> replies = freeBoard.getReplise();
			FreeBoardReply freeBoardReply = new FreeBoardReply();
			freeBoardReply.setReply("Reply........");
			freeBoardReply.setReplyer("replyer00");
			freeBoardReply.setBoard(freeBoard);
			replies.add(freeBoardReply);
			freeBoard.setReplise(replies);
			freeBoardRepository.save(freeBoard);
		});
	}

	@Test
	public void insertReply1Way() {
		FreeBoard freeBoard = new FreeBoard();
		freeBoard.setBno(199L);

		FreeBoardReply freeBoardReply = new FreeBoardReply();
		freeBoardReply.setReply("REPLY..........");
		freeBoardReply.setReplyer("replyer00");
		freeBoardReply.setBoard(freeBoard);

		freeBoardReplyRepository.save(freeBoardReply);
	}

}
