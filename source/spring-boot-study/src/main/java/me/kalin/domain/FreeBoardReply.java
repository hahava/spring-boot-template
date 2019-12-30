package me.kalin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString(exclude = "board")
@Entity
@Table(name = "tbl_free_replise", indexes = {@Index(unique = false, columnList = "board_bno")})
@EqualsAndHashCode(of = "rno")
public class FreeBoardReply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private String reply;
	private String replyer;

	@CreationTimestamp
	private Timestamp replyDate;
	@UpdateTimestamp
	private Timestamp updateTime;

	@ManyToOne
	private FreeBoard board;

}