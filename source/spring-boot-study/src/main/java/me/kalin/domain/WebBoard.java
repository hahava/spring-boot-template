package me.kalin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "web_board")
@ToString
@EqualsAndHashCode()
public class WebBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	private String writer;
	private String title;
	private String content;

	@CreationTimestamp
	private LocalDateTime creationTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
}
