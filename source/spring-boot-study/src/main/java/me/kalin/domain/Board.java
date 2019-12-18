package me.kalin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_boards")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	private String title;
	private String writer;
	private String content;

	@CreationTimestamp
	private LocalDateTime regDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
}
