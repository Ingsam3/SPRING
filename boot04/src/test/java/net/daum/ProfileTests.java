package net.daum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;
import net.daum.dao.MemberRepository;
import net.daum.dao.ProfileRepository;
import net.daum.vo.MemberVO;
import net.daum.vo.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log // Lombok 라이브러리의 로그 기록을 사용할 때 이용하는 애노테이션
@Commit // DB commit 기능 사용할 때
public class ProfileTests {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired 
	private ProfileRepository profileRepo;
	
	//20명의 회원 자료 추가
	@Test
	public void testInsertMembers() {
		IntStream.range(1, 21).forEach(i->{
			//람다식 스트림
			//1부터 20까지의 숫자 생성
			MemberVO mem = new MemberVO();
			mem.setUid2("user"+i);
			mem.setUpw("pwd"+i);
			mem.setUname("사용자"+i);
			//this.memberRepo.save(mem); // 회원 정보 1~20 저장
		});
	}//testInsertMembers()
	
	//특정 회원의 프로필 사진 추가
	@Test
	public void testInsertProfile() {
		
		MemberVO member = new MemberVO();
		member.setUid2("user1");//user1 회원 아이디 저장
		
		for(int i =1; i<5; i++) {//4개의 프로필 사진 저장
			Profile profile01 = new Profile();
			profile01.setFname("face"+i+".jpg");// 4개의 프로필 파일명 저장
			
			if(i==1) {
				profile01.setCurrent2(true);//첫번째 회원 프로필 사진은 현재 사용중인 것으로 함
				
			}
			profile01.setMember(member);
			
			//this.profileRepo.save(profile01);
			
		}//for
	}//testInsertProfile()
	
	
	//user1 아이디 정보와 프로필 사진 개수 => Fetch Join
	@Test 
	public void testFetchJoin01() {
		//List<Object[]> result = this.memberRepo.getMemberVOWithProfileCount("user1");
		//result.forEach(arr -> System.out.println(Arrays.toString(arr)));
		//arr 배열 원소값을 문자열로 변환해서 반환
		
	}//testFetchJoin01()
	
	
	//user1 아이디 정보와 사용중인 프로필 사용 정보 => Fetch Join2
	@Test 
	public void testFetchJoin02() {
		List<Object[]> result = this.memberRepo.getMemberVOWithProfile("user1");
		result.forEach(arr->System.out.println(Arrays.toString(arr)));
		
	}//testFetchJoin02() 
}
