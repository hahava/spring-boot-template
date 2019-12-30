package me.kalin.persistence;

import lombok.extern.java.Log;
import me.kalin.domain.PDSBoard;
import me.kalin.domain.PDSfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log
public class PDSBoardTest {

	@Autowired
	private PDSBoardRepository pdsBoardRepository;

	@Test
	public void testInsertPDS() {
		PDSBoard pdsBoard = new PDSBoard();
		pdsBoard.setPname("Docs");

		PDSfile pdsFile = new PDSfile();
		pdsFile.setPdsFile("file.doc");

		PDSfile pdsFileSe = new PDSfile();
		pdsFileSe.setPdsFile("file2.doc");

		pdsBoard.setPdSfiles(Arrays.asList(pdsFile, pdsFileSe));

		log.info("save pds");
		pdsBoardRepository.save(pdsBoard);
	}

	@Commit
	@Test
	public void testUpdateFileName() {
		String newName = "updatedFile.doc";
		Optional<PDSBoard> result = pdsBoardRepository.findById(1L);
		result.ifPresent(pdsBoard -> {
			log.info("update !!");
			PDSfile target = new PDSfile();
			target.setFno(1L);
			target.setPdsFile(newName);
			int index = pdsBoard.getPdSfiles().indexOf(target);
			if (index > 1) {
				List<PDSfile> list = pdsBoard.getPdSfiles();
				list.remove(index);
				list.add(target);
				pdsBoard.setPdSfiles(list);
			}
			pdsBoardRepository.save(pdsBoard);
		});
	}
}
