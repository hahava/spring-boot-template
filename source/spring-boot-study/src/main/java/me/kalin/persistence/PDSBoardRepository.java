package me.kalin.persistence;

import me.kalin.domain.PDSBoard;
import org.springframework.data.repository.CrudRepository;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long> {

}
