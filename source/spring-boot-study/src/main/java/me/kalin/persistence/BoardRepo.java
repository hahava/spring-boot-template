package me.kalin.persistence;

import me.kalin.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BoardRepo extends CrudRepository<Board, Long> {
	Collection<Board> findByWriter(String writer);

	Collection<Board> findByWriterContaining(String writerNo);

	Collection<Board> findByWriterOrContent(String title, String content);

	Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyWord, Long num);

	Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
}
