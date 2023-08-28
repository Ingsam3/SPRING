package net.daum.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import net.daum.service.AdminBbsService;
import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

@Controller
public class AdminBbsController {//관리자 자료실 컨트롤러

	@Autowired
	private AdminBbsService adminBbsService;
	
	//관리자 자료실 목록
	@RequestMapping("/admin_bbs_list")
	public ModelAndView admin_bbs_list(BbsVO b,HttpServletResponse response,
			HttpServletRequest request,HttpSession session,PageVO p)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String admin_id = (String)session.getAttribute("admin_id");//관리자 세션 아이디를 구함
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('관리자로 로그인 하세요!');");
			out.println("location='admin_login';");
			out.println("</script>");
		}else {
			int page=1;//쪽번호
			int limit=7;//한페이지에 보여지는 목록개수
			if(request.getParameter("page") != null) {
				page=Integer.parseInt(request.getParameter("page"));         
			}
			String find_name=request.getParameter("find_name");//검색어
			String find_field=request.getParameter("find_field");//검색 필드
			p.setFind_field(find_field);
			p.setFind_name("%"+find_name+"%");
			//%는 sql문에서 검색 와일드 카드 문자로서 하나이상의 임의의 모르는 문자와 매핑 대응, 하나의 모르는 문자와 매핑 대응하는 와일드 카드문자는 _

			int listcount=this.adminBbsService.getListCount(p);
			//검색전 전체 레코드 개수 또는 검색후 레코드 개수
			System.out.println("총 게시물수:"+listcount+"개");

			p.setStartrow((page-1)*7+1);//시작행번호
			p.setEndrow(p.getStartrow()+limit-1);//끝행번호

			List<BbsVO> blist=this.adminBbsService.getadminBbsList(p);
			//검색 전후 목록 p에 4 값 입력됨

			//총페이지수
			int maxpage=(int)((double)listcount/limit+0.95);
			//현재 페이지에 보여질 시작페이지 수(1,11,21)
			int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			//현재 페이지에 보여줄 마지막 페이지 수(10,20,30)
			int endpage=maxpage;
			if(endpage > startpage+10-1) endpage=startpage+10-1;

			ModelAndView listM=new ModelAndView();
			
			listM.addObject("blist",blist);//blist 키이름에 값 저장
			listM.addObject("page",page);
			listM.addObject("startpage",startpage);
			listM.addObject("endpage",endpage);
			listM.addObject("maxpage",maxpage);
			listM.addObject("listcount",listcount);   
			listM.addObject("find_field",find_field);
			listM.addObject("find_name", find_name);

			listM.setViewName("admin/admin_bbs_list");//뷰페이지 경로
			return listM;
			//return null;
		}
		return null;
	}//admin_bbs_list()
	
	//관리자 자료실 글쓰기
	@GetMapping("/admin_bbs_write")
	public ModelAndView admin_bbd_write(HttpServletResponse response,
			HttpSession session, HttpServletRequest request) throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(isAdminLogin(session, response)) {//true 인 경우 실행 == true 생략
			int page =1;
			if(request.getParameter("page") != null) {
				page=Integer.parseInt(request.getParameter("page"));
				
			}
			ModelAndView wm = new ModelAndView("admin/admin_bbs_write");
			wm.addObject("page",page);//페이징에서 책갈피 기능 때문에 추가
			return wm;
		}
		
		return null;
	}//admin_bbs_write()
	
	//관리자 자료실 저장
	@PostMapping("/admin_bbs_write_ok")
	public ModelAndView admin_bbs_write_ok(HttpSession session, HttpServletResponse response,
			HttpServletRequest request, BbsVO b) throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(isAdminLogin(session, response)) {
			
			String saveFolder=request.getRealPath("upload");
	         //이진파일 업로드 서버경로
	         int fileSize=5*1024*1024;//이진파일 업로드 최대크기
	         MultipartRequest multi=null;//이진파일을 받을 참조변수

	         multi=new MultipartRequest(request,saveFolder,
	               fileSize,"UTF-8");
	         String bbs_name=multi.getParameter("bbs_name");
	         String bbs_title=multi.getParameter("bbs_title");
	         String bbs_pwd=multi.getParameter("bbs_pwd");
	         String bbs_cont=multi.getParameter("bbs_cont");

	         File upFile=multi.getFile("bbs_file");//첨부한 이진파일
	         //을 받아옴.
	         if(upFile != null) {//첨부한 이진파일이 있다면
	            String fileName=upFile.getName();//첨부한 파일명
	            Calendar c=Calendar.getInstance();//칼렌더는 추상
	            //클래스로 new로 객체 생성을 못함. 년월일 시분초 값을 반환
	            int year=c.get(Calendar.YEAR);//년도값
	            int month=c.get(Calendar.MONTH)+1;//월값. +1을 한
	            //이유가 1월이 0으로 반환 되기 때문이다.
	            int date=c.get(Calendar.DATE);//일값
	            String homedir=saveFolder+"/"+year+"-"+month+"-"+date;//오늘
	            //날짜 폴더 경로 저장
	            File path1=new File(homedir);
	            if(!(path1.exists())) {
	               path1.mkdir();//오늘날짜 폴더경로를 생성
	            }
	            Random r=new Random();
	            int random=r.nextInt(100000000);

	            /*첨부 파일 확장자 구함*/
	            int index=fileName.lastIndexOf(".");//마침표 위치
	            //번호를 구함
	            String fileExtension=fileName.substring(index+1);//마침표
	            //이후부터 마지막 문자까지 구함.첨부파일 확장자를 구함
	            String refileName="bbs"+year+month+date+random+"."+
	                  fileExtension;//새로운 이진파일명 저장
	            String fileDBName="/"+year+"-"+month+"-"+date+"/"+
	                  refileName;//디비에 저장될 레코드값
	            upFile.renameTo(new File(homedir+"/"+refileName));
	            //바뀌어진 이진파일로 업로드
	            b.setBbs_file(fileDBName);
	         }else {//mybatis에서는 컬럼에 null을 insert하지 못함.
	            String fileDBName="";
	            b.setBbs_file(fileDBName);//첨부하지 않았을때 빈공백을 저장
	         }
	         b.setBbs_name(bbs_name); b.setBbs_title(bbs_title);
	         b.setBbs_pwd(bbs_pwd); b.setBbs_cont(bbs_cont);

	         this.adminBbsService.adminInsertBbs(b);//자료실 저장

	         return new ModelAndView("redirect:/admin_bbs_list"); 
		}
		
		return null;
	}//admin_bbs_write_ok()
	
	
	//관리자 자료실 상세정보 +수정폼
	@RequestMapping("/admin_bbs_cont")
	public ModelAndView admin_bbs_cont(int no, int page, String state, 
			HttpServletResponse response,
			HttpSession session) throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(isAdminLogin(session, response)) {
			//로그인 된 상태일 때
			BbsVO bc = this.adminBbsService.getadminBbsCont(no);
			//번호에 해당되는 레코드 값 적용
			String bbs_cont = bc.getBbs_cont().replace("/n", "<br>");
			/*엔터키 친 부분을 줄바꿈해서 내용보기 한다*/
			ModelAndView cm = new ModelAndView();
			cm.addObject("b",bc);
			cm.addObject("bbs_cont",bbs_cont);
			cm.addObject("page",page); //책갈피 기능
			
			if(state.equals("cont")) {
				//관리자 자료실 상세정보 보기
				cm.setViewName("./admin/admin_bbs_cont");
			}else if(state.equals("edit")) {
				//관리자 자료실 수정 폼
				cm.setViewName("./admin/admin_bbs_edit");
			}
			return cm;
		}//if
		return null;
	}//admin_bbs_cont()
	
	//관리자 자료실 수정 완료
	@PostMapping("/admin_bbs_edit_ok")
	public ModelAndView admin_bbs_edit_ok(HttpServletRequest request, HttpServletResponse response,
			HttpSession session , BbsVO b)throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		if(isAdminLogin(session, response)) {
			
			
		}
		return null;
	}//admin_bbs_edit_ok()
	
	
	
	//반복적인 관리자 로그인을 안 히기 위한 코드 추가
	public static boolean isAdminLogin(HttpSession session, HttpServletResponse response
			)throws Exception {
		
		PrintWriter out=response.getWriter();
		String admin_id = (String)session.getAttribute("admin_id");
		//관리자 세션 아이디를 구함
		if(admin_id == null) {//관리자 로그아웃 됐을 때
			out.println("<script>");
			out.println("alert('관리자로 로그인 하세요!');");
			out.println("location='admin_login';");
			out.println("</script>");
			
			return false;
		}
		return true;
	}//isAdminLogin()
	
}//AdminBbsController.java
