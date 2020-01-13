package me.kalin.persistence;

import me.kalin.domain.WebBoard;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WebBoardRepository extends PagingAndSortingRepository<WebBoard, Long> {
}
