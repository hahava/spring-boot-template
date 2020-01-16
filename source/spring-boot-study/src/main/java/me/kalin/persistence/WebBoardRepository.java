package me.kalin.persistence;

import me.kalin.domain.WebBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WebBoardRepository extends PagingAndSortingRepository<WebBoard, Long> {
	Page<WebBoard> findByContentContaining(String word,Pageable pageable);
}
