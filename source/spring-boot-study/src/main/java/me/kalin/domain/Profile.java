package me.kalin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_profile")
@ToString(exclude = "member")
@EqualsAndHashCode(of = "fno")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	private String fname;
	private boolean current;

	@ManyToOne
	private Member member;

	@CreationTimestamp
	private LocalDateTime creationTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;

}
