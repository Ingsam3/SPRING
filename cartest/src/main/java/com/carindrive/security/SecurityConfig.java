package com.carindrive.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity //스프링 웹 시큐리티로 인식되게 @EnableWebSecurity 애노테이션 추가
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {//스프링 웹 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속받는다.
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ZerockUsersService zerockUsersService;
	
	@Bean
	public PasswordEncoder passwordEncoder() { //비번 암호화 빈등록
		return new BCryptPasswordEncoder();
	}//PasswordEncoder 빈등록하고 MemberTests JUnit 클래스 등에서 @Autowired 자동의존성 주입해야 에러가 안난다.	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {//configure() 메서드를 오버라이딩을 해서 간단한 로그 메시지를 출력한다.
		//HttpSecurity는 웹과 관련된 다양한 보안설정을 걸어 줄 수 있다.
	
		log.info("security config ......");
		
		http.authorizeRequests().antMatchers("/guest/**").permitAll();//authorizeRequests()는 시큐리티 처리에서 HttpServletRequest에 해당한다.
        /* antMatchers()에서는 특정한 경로를 지정한다. permitAll()은 모든 사용자가 접근할 수 있다는 것을 의미한다. 
         */
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER"); //hasRole()은 특정권한을 가진 사람만이 접근할 수 있다는 것을 의미한다.
		
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.formLogin().loginPage("/login");
		/*http.formLogin()은 form 태그기반의 로그인을 지원하겠다는 설정이다. 이를 이용하면 별도의 로그인 페이지를 제작하지 않아도 스프링 시큐리티에서 제공하는 /login 매핑주소로
		인식되는 기본 로그인 페이지가 띄워진다. 
		loginPage("/member_login");을 사용하면 매핑주소가 member_login인 사용자 즉 커스텀 로그인 페이지를 만들 수 있다.
		*/
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");//403 접근금지 에러가 났을 때 실행
		
		//http.logout().invalidateHttpSession(true);//세션무효화
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);//세션무효화
		
		//http.userDetailsService(zerockUsersService);//HttpSecurity는 ZerockUsersService를 이용
		
		http.rememberMe().key("zerock").userDetailsService(zerockUsersService)	
		//rememberMe()에서 쿠키값을 암호화 해서 전달하므로 암호의 '키(key)'를 지정하여 사용
		.tokenRepository(getJDBCRepository())
	    .tokenValiditySeconds(60*60*24);//쿠키 유효 시간을 초단위로 설정 => 60초*60분*24시간 즉 24시간 쿠키 유효시간 설정			
    }//configure()
	
	private PersistentTokenRepository getJDBCRepository() {
		/*  SecurityConfig 에서 rememberMe()를 처리할 때 JdbcTokenRepositoryImpl을 지정해 주어야 하는대 기본적으로 
		 *   DataSource가 필요하므로 의존성을 주입한다.
		 */

		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
		
	//@Autowired//화면에 로그인 페이지가 띄워져도 어떤 아이디나 비번을 입력해도 로그인 실패가 된다. 이런 경우는 로그인 되게 만들기 위해서 AuthenticationManagerBuilder
	//을 주입해서 인증에 대한 처리를 해야 한다.
	//public void configureGlobal(AuthenticationManagerBuilder auth) throws
	//Exception {//AuthenticationManagerBuilder는 인증에 대한 다양한 설정을 할 수 있다. 예를 들어 메모리상에 정보만을 이용한다든지, jdbc등을 이용해서 인증 처리가 가능하다.
		//여기서는 메모리상의 인증 정보를 활용한다.		
	
	// log.info("build Auth global........");
	
	// auth.inMemoryAuthentication().withUser("manager").password("{noop}1111").roles("MANAGER");//사용자 manager,비번 1111,권한 MANAGER 지정
	 //Spring Security 4에서는 메모리 내 인증을 사용하여 암호를 인코딩 즉 암호화 하지않고 일반 텍스트로 저장할 수 있었다. Spring Security 5부터는 비번을 인코딩 즉
	 //암호화 해서 저장한다. 그러므로  There is no PasswordEncoder mapped for the id “null” 오류를 내지 않기 위해서는 {noop}을 사용해서
	 //비번을 인코딩 즉 암호화없이 처리한다. 
	//}
	
	//@Autowired
	 //public void configureGlobal(AuthenticationManagerBuilder auth) throws
	 //Exception {
	
	 //log.info("build Auth global........");
	
	 //String query1 = "SELECT uid2 username, upw password FROM tbl_members2 WHERE uid2= ? ";
	
	 //String query2 = "SELECT member uid2, role_name role FROM tbl_member_roles WHERE member = ?";
	
	 //auth.jdbcAuthentication()  //JdbcUserDetailsManagerConfigurer 객체를 반환
	 //.dataSource(dataSource) //DataSource 주입
	 //.usersByUsernameQuery(query1) //피라미터 값으로 쿼리문 전달 ==> 아이디를 기준으로 회원정보 검색
	 //.rolePrefix("ROLE_") // /manager 매핑주소를 실행하면 STS 콘솔창에 [GET /manager] with attributes [hasRole('ROLE_MANAGER')] 권한 목록이 띄워진다.
	 //하지만 실제 DB에는 MANAGER권한정보만 저장되어 있다. 필요한 권한은 ROLE_MANAGER 이므로 ROLE_접두어 문자를 추가한다. 그래서 결국 ROLE_MANAGER권한으로 인식한다.
	 //.authoritiesByUsernameQuery(query2); //아이디를 기준으로 아이디와 권한 정보 검색	
	 //}
}
