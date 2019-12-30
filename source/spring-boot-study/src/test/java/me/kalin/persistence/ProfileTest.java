package me.kalin.persistence;

import lombok.extern.slf4j.Slf4j;
import me.kalin.domain.Member;
import me.kalin.domain.Profile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@Commit
public class ProfileTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Test
	public void testInsertMembers() {
		IntStream.range(1, 101).forEach(i -> {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUname("사용자" + i);
			memberRepository.save(member);
		});
	}

	@Test
	public void testInsertProfile() {
		Member member = new Member();
		member.setUid("user1");

		for (int i = 0; i < 5; i++) {
			Profile profile = new Profile();
			profile.setFname("face" + i + ".jpg");

			if (i == 1) {
				profile.setCurrent(true);
			}

			//			profile.setMember(member);
			//			profileRepository.save(profile);
		}

	}

	@Test
	public void testFetchJoin() {
		List<Object[]> result = memberRepository.getMemberWithProfile("user1");
		result.forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}

}
