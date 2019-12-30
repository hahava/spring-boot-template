package me.kalin.persistence;

import me.kalin.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, String> {

	@Query("select m.uid, count(p) from Member m left outer join Profile p ON m.uid = p.member where m.uid = ?1 group by m")
	List<Object[]> getMemberWithProfile(String uid);
}
