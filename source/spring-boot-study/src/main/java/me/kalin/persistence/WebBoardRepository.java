package me.kalin.persistence;

import me.kalin.domain.WebBoard;
import org.springframework.data.repository.CrudRepository;

public interface WebBoardRepository extends CrudRepository<WebBoard, Long> {


}
