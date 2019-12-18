package me.kalin.persistence;

import me.kalin.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepo extends CrudRepository<Board, Long> {
}
