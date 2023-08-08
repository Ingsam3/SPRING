package net.daum.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTests {

	@Setter(onMethod_ = @Autowired) //setter()메서드를 통한 자동의존성인 DI 주입
	private PasswordEncoder pwencoder; //비번암호화
	
	@Setter(onMethod_ = @Autowired)
	private DataSource ds; //DBCP 커넥션 풀 관리 ds
	
	@Test //샘플 회원 100명 저장
	public void testInsertMember() {
      String sql = "insert into tbl_member(userid,userpw,username) values(?,?,?)";
      
      for(int i=0;i<100;i++) {
    	 Connection con=null;//데이터 베이스 연결 con
    	 PreparedStatement pstmt=null;//쿼리문 수행 pstmt
    	 
    	 try {
    		 con=ds.getConnection();//커넥션 풀 관리 ds로 con생성
    		 pstmt=con.prepareStatement(sql);//쿼리문을 미리 컴파일 하여 수행할 pstmt생성
    		 
    		 pstmt.setString(2,pwencoder.encode("pw"+i));//pw0~pw99까지 비번 암호화
    		 
    		 if(i<80) {//user0~user79까지 일반사용자
    			 pstmt.setString(1,"user"+i);//아이디 저장
    			 pstmt.setString(3,"일반사용자"+i);//일반사용자0부터 79까지 문자열로 저장
    		 }else if(i<90) {//manager80~89까지 운영자
    			 pstmt.setString(1,"manager"+i);
    			 pstmt.setString(3, "운영자"+i);
    		 }else {//admin90~99까지 관리자
    			 pstmt.setString(1,"admin"+i);
    			 pstmt.setString(3,"관리자"+i);
    		 }//if else if
    		 
    		 pstmt.executeUpdate(); //100번 쿼리문 수행
    	 }catch(Exception e) {e.printStackTrace();}
    	 finally {
    		 try {
    			 if(pstmt != null) pstmt.close();
    			 if(con != null) con.close();
    		 }catch(Exception e) {e.printStackTrace();}
    	 }
      }//for
	}//testInsertMember()
	
	@Test //권한 100개 저장
	public void testInsertAuth() {
        String sql="insert into tbl_member_auth (userid,auth) values(?,?)";
        
        for(int i=0;i<100;i++) {
        	Connection con=null;
        	PreparedStatement pstmt=null;
        	
        	try {
        		con=ds.getConnection();
        		pstmt=con.prepareStatement(sql);
        		
        		if(i<80) {//일반사용자 권한 설정
        			pstmt.setString(1,"user"+i);
        			pstmt.setString(2,"ROLE_USER");
        		}else if(i<90) {//운영자 권한 설정
        			pstmt.setString(1,"manager"+i);
        			pstmt.setString(2,"ROLE_MEMBER");
        		}else {//관리자 권한
        			pstmt.setString(1,"admin"+i);
        			pstmt.setString(2,"ROLE_ADMIN");
        		}//if else if
        		
        		pstmt.executeUpdate();
        		
        	}catch(Exception e) {e.printStackTrace();}
        	finally {
        		try {
        			if(pstmt != null) pstmt.close();
        			if(con != null) con.close();
        		}catch(Exception e) {e.printStackTrace();}
        	}
        }//for
	}//testInsertAuth()
}






