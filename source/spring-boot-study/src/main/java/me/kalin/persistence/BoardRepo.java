package me.kalin.persistence;

import me.kalin.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BoardRepo extends CrudRepository<Board, Long> {
	Collection<Board> findByWriter(String writer);

	Collection<Board> findByWriterContaining(String writerNo);

	Collection<Board> findByWriterOrContent(String title, String content);

	Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyWord, Long num);

	Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);

	List<Board> findByBnoGreaterThanOrderByBno(Long bno, Pageable paging);

	Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
}
