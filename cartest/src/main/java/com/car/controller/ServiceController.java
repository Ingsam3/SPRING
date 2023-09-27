package com.carindrive.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carindrive.service.ServiceSv;
import com.carindrive.vo.PageVO;
import com.carindrive.vo.QnaVO;
import com.carindrive.vo.ServiceVO;
import com.oreilly.servlet.MultipartRequest;

@Controller // 스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/service/*")
public class ServiceController {
	
	@Autowired
	private ServiceSv serviceSv;

	
	// service 메인 공지사항 5개 보기 
   @RequestMapping(value="/service_center")
   public ModelAndView service_center(HttpServletRequest request, PageVO p) {
	   /* 검색 관련 부분 */
		String find_name=request.getParameter("find_name");//검색어
		p.setFind_name("%"+find_name+"%");
		
		List<ServiceVO> glist = this.serviceSv.getList();
		   
		ModelAndView listS = new ModelAndView();
				
		listS.addObject("glist",glist);// 목록을 저장
		listS.addObject("find_name", find_name);//
		listS.setViewName("service/service_center");

		return listS;
	}
   
   
   
   // 공지사항 목록
   @RequestMapping("/service_notice")
	public ModelAndView service_notice(HttpServletRequest request, ServiceVO s, PageVO p) {

		int page=1;
		int limit=10;// 한 페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
			// 페이지 번호를 정수 숫자로 변경해서 저장         
		}

		 /* 검색 관련 부분 */
		 String find_name=request.getParameter("find_name");//검색어
		 String find_field=request.getParameter("find_field");//검색 필드
		 p.setFind_name("%"+find_name+"%");
		 p.setFind_field(find_field);
		
		 int listcount=this.serviceSv.getListCount(p);
		 //검색전 총레코드 개수,검색후 레코드 개수
		 // xml ; notice_row

		p.setStartrow((page-1)*10+1);//시작행번호
		p.setEndrow(p.getStartrow()+limit-1);//끝행 번호

		List<ServiceVO> slist = this.serviceSv.getQuestionList(p);
		// question_list

		//총 페이지수
		int maxpage=(int)((double)listcount/limit+0.95);
		//시작페이지(1,11,21 ..)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage=maxpage;
		if(endpage>startpage+10-1) endpage=startpage+10-1;

		 ModelAndView listS = new ModelAndView();
		
		listS.addObject("slist",slist);// 목록을 저장
		listS.addObject("page",page);// 쪽번호
		listS.addObject("startpage",startpage);// 시작페이지
		listS.addObject("endpage",endpage);// 마지막 페이지
		listS.addObject("maxpage",maxpage);// 최대 페이지
		listS.addObject("listcount",listcount);// 검색전후 레코드 개수
		listS.addObject("find_field", find_field);// 검색 필드
		listS.addObject("find_name", find_name);// 검색어
      
		listS.setViewName("service/service_notice");
		
		return listS;
	}
   
   
   
   // 공지사항 내용 보기 
	@RequestMapping("/service_ncont")
	public ModelAndView service_ncont(
			@RequestParam("cs_no") int cs_no)
	{
		ServiceVO g = this.serviceSv.getCs_Cont(cs_no);
		String g_cont=g.getCs_cont().replace("\n","<br/>");

		ModelAndView gm = new ModelAndView("service/service_ncont");
		gm.addObject("g",g);
		gm.addObject("g_cont",g_cont);
		return gm;
	}
   
   
   
   //자주 묻는 질문 
   @RequestMapping(value="/service_question", method=RequestMethod.GET)
   public ModelAndView service_question(
		   PageVO p, 
		   HttpServletRequest request) {
	   
	   // 페이징 설정
	   int page = 1;
	   int limit = 5;
	   if(request.getParameter("page")!= null) {
		   page = Integer.parseInt(request.getParameter("page"));
	   }
	   
	   int listcount=this.serviceSv.getListCount(p);
	   //전체 레코드 개수 
	   
	   p.setStartrow((page-1)*5+1); // 시작행 번호
	   p.setEndrow(p.getStartrow()+limit-1); // 끝행 번호
	   
	   List<ServiceVO> slist = this.serviceSv.getQuestionList(p);
	   
	 //총페이지수
	   int maxpage=(int)((double)listcount/limit+0.95);
	   //현재 페이지에 보여질 시작페이지 수(1,11,21)
	   int startpage=(((int)((double)page/5+0.9))-1)*5+1;
	   //현재 페이지에 보여줄 마지막 페이지 수(10,20,30)
	   int endpage=maxpage;
	   if(endpage > startpage+5-1) endpage=startpage+5-1;
	   
	   ModelAndView listS = new ModelAndView("./service/service_question");
	   listS.addObject("slist", slist);
	   listS.addObject("startpage", startpage);
	   listS.addObject("endpage", endpage);
	   listS.addObject("maxpage", maxpage);
	   listS.addObject("listcount", listcount);
	   
	   listS.setViewName("service/service_question");
	   
	   return listS;
   }
   
   @RequestMapping("/service_question00")
   public ModelAndView service_q00(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList00();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question01")
   public ModelAndView service_q01(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList01();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   

   
   @RequestMapping("/service_question02")
   public ModelAndView service_q02(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList02();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question03")
   public ModelAndView service_q03(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList03();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question04")
   public ModelAndView service_q04(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList04();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question05")
   public ModelAndView service_q05(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList05();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question06")
   public ModelAndView service_q06(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList06();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
   
   @RequestMapping("/service_question07")
   public ModelAndView service_q07(){
	   List<ServiceVO> slist = this.serviceSv.getQuestionList07();
	   ModelAndView listS = new ModelAndView();
	   listS.addObject("slist", slist);
	   listS.setViewName("service/service_question01");
	   return listS;
   }
  
   
   
   // 1대1문의 작성
   @GetMapping("/service_qwrite")
   public ModelAndView service_qwrite(HttpServletRequest request) {
		int page=1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));			
		}
		
		ModelAndView wm = new ModelAndView();
		wm.addObject("page",page);
		wm.setViewName("service/service_qwrite");
		
      return wm;
   }
   
   // 1대1문의 저장
   @PostMapping("/qna_write_ok") //post로 접근하는 매핑주소 처리
	public String qna_write_ok(QnaVO q,HttpServletRequest request, HttpSession session) throws Exception{
		String saveFolder=request.getRealPath("upload");
		//이진 파일 업로드 서버 경로            
		int fileSize=5*1024*1024; //이진파일 업로드 최대크기
		MultipartRequest multi=null; //이진파일을 가져올 참조변수

		multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");   

		String cq_id=(String)session.getAttribute("id");
		String cq_title=multi.getParameter("cq_title");
		String cq_pwd=multi.getParameter("cq_pwd");
		String cq_cont=multi.getParameter("cq_cont");

		File upFile = multi.getFile("cq_file");//첨부한 이진파일을 가져온다.

		if(upFile != null) { //첨부한 이진파일이 있는 경우 실행
			String fileName=upFile.getName(); //첨부한 파일명
			Calendar cal=Calendar.getInstance(); //년월일 시분초 값을 반환
			int year=cal.get(Calendar.YEAR);//년도값
			int month=cal.get(Calendar.MONTH)+1; //월값, +1을 한 이유는 1월이 0으로 반환 되기 때문에
			int date=cal.get(Calendar.DATE); //일값

			String homedir=saveFolder+"/"+year+"-"+month+"-"+date; //오늘 날짜 폴더 경로 저장
			File path01=new File(homedir);

			if(!(path01.exists())){
				path01.mkdir();//오늘날짜 폴더 생성
			}
			Random r=new Random();//난수를 발생시키는 클래스
			int random=r.nextInt(100000000);//0이상 1억 미만의 정수 숫자 난수 발생

			/*첨부 파일 확장자를 구함*/
			int index=fileName.lastIndexOf(".");
			//마침표를 맨 오른쪽부터 찾아서 가장 먼저 나오는 .의 위치번호를 맨 왼쪽부터 카운트해 반환
			//첫문자는 0부터 시작
			String fileExtendsion=fileName.substring(index+1);
			//마침표 이후부터 마지막 문자까지 구함 => 첨부파일 확장자를 구함.
			String refileName="file"+year+month+date+random+"."+fileExtendsion; //새로운 파일명 저장
			String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;
			//데이터베이스에 저장될 레코드값
			upFile.renameTo(new File(homedir+"/"+refileName));
			//생성된 폴더에 변경된 파일명으로 실제 업로드

			q.setCq_file(fileDBName);
		}else {//첨부파일이 없는 경우
			String fileDBName="";
			q.setCq_file(fileDBName);
		}
		q.setCq_id(cq_id); q.setCq_title(cq_title);
		q.setCq_pwd(cq_pwd); q.setCq_cont(cq_cont);

		this.serviceSv.insertQna(q); // 문의 저장

		return "redirect:/service_qboard";// 목록보기 이동
	} // 게시물 저장

   
   // 1대1문의 목록보기
	@RequestMapping("/service_qboard")
	public ModelAndView service_qboard(HttpServletRequest request, QnaVO q, PageVO p) {

		int page=1;
		int limit=10;// 한 페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
			// 페이지 번호를 정수 숫자로 변경해서 저장         
		}

		 /* 검색 관련 부분 */
		 String find_name=request.getParameter("find_name");//검색어
		 String find_field=request.getParameter("find_field");//검색 필드
		 p.setFind_name("%"+find_name+"%");
		 p.setFind_field(find_field);
		
		int totalCount=this.serviceSv.getRowCount(p);
		//검색전 총레코드 개수,검색후 레코드 개수

		p.setStartrow((page-1)*10+1);//시작행번호
		p.setEndrow(p.getStartrow()+limit-1);//끝행 번호

		List<QnaVO> qnalist = this.serviceSv.getQnaList(p); //검색 전후 목록

		//총 페이지수
		int maxpage=(int)((double)totalCount/limit+0.95);
		//시작페이지(1,11,21 ..)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage=maxpage;
		if(endpage>startpage+10-1) endpage=startpage+10-1;

		ModelAndView listQ = new ModelAndView("./service/service_qboard");
		//생성자 인자값으로 뷰페이지 경로 설정=> /WEB-INF/service/service_qboard.jsp
		
		listQ.addObject("qnalist",qnalist);// 자료실 목록을 저장
		listQ.addObject("page",page);// 쪽번호
		listQ.addObject("startpage",startpage);// 시작페이지
		listQ.addObject("endpage",endpage);// 마지막 페이지
		listQ.addObject("maxpage",maxpage);// 최대 페이지
		listQ.addObject("listcount",totalCount);// 검색전후 레코드 개수
		listQ.addObject("find_field", find_field);// 검색 필드
		listQ.addObject("find_name", find_name);// 검색어
       
		return listQ;
	}
	
	
	// 1대1문의 확인(비밀번호 확인)
   @RequestMapping("/service_qpwdCheck")
   public ModelAndView service_qpwdCheck(
		   int cq_no, int page, String state, QnaVO q){
	   
		q = this.serviceSv.qpwdCheck(cq_no);
		
		ModelAndView pc = new ModelAndView();
		pc.addObject("q", q);
		pc.addObject("page", page);
		pc.addObject("cq_no", cq_no);
		pc.addObject("state", state);
		pc.setViewName("/service/service_qpwdCheck");
		
		return pc;
   }
	
   
   @RequestMapping("/qpwdCheck_ok")
   public String qpwdCheck_ok(
		   int cq_no, int page, String state, HttpServletRequest request,
		   HttpServletResponse response, QnaVO q) throws IOException {
	   
	   response.setContentType("text/html; charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   
	   String cq_pwd = request.getParameter("cq_pwd");
	   
	   if(!q.getCq_pwd().equals(cq_pwd)) {
		   out.println("<script>");
		   out.println("alert('비번이 다릅니다!');");
		   out.println("location='service_qpwdCheck';");
		   out.println("</script>"); 
	   } else {
		   ModelAndView pc = new ModelAndView();
		   pc.addObject("q", q);
		   return "redirect:/service/service_qcont?cq_no="+cq_no+"&state="+state+"&page="+page;
		   }
	   return null;
   }
	
	
	//1대1문의 내용보기+답변폼+수정폼+삭제폼
	@RequestMapping("/service_qcont")
	public ModelAndView service_qcont(
			HttpSession session, int cq_no,String state,int page,QnaVO q) {
		
		String cq_id=(String)session.getAttribute("id");
		
		if(state.equals("cont")) {
			q = this.serviceSv.getQnaCont2(cq_no);
		}
		
		ModelAndView cm = new ModelAndView();
		cm.addObject("page",page);//페이징에서 책갈피 기능 때문에 쪽번호 저장
		cm.addObject("q",q);
		cm.addObject("cq_id",cq_id);
		
		if(state.equals("cont")) {//내용보기 일때 실행할 뷰페이지 경로
			cm.setViewName("./service/service_qcont");	
		}else if(state.equals("edit")) {//자료실 수정폼일때
			cm.setViewName("./service/service_qedit");
		}else if(state.equals("del")) {//삭제폼일 때
			cm.setViewName("./service/service_qdel");
		}
		return cm;
	}
	
	
	
	// 1대1문의 수정
		@RequestMapping(value="/qna_edit_ok",method=RequestMethod.POST)
		public ModelAndView qna_edit_ok(HttpServletRequest request,
				HttpServletResponse response,QnaVO q, HttpSession session) throws Exception{
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out=response.getWriter();
			String saveFolder = request.getRealPath("upload");

			int fileSize = 5*1024*1024;//이진파일 업로드 최대크기
			MultipartRequest multi=null;//첨부된 파일을 받을 참조변수
			
			multi = new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
			
			int cq_no = Integer.parseInt(multi.getParameter("cq_no"));
			
			int page=1;
			if(multi.getParameter("page") != null) {
				page=Integer.parseInt(multi.getParameter("page"));
			}
			
			String cq_id=(String)session.getAttribute("id");
			String cq_title=multi.getParameter("cq_title");
			String cq_pwd=multi.getParameter("cq_pwd");
			String cq_cont=multi.getParameter("cq_cont");
			
			QnaVO db_pwd = this.serviceSv.getQnaCont2(cq_no);
			
			if(!db_pwd.getCq_pwd().equals(cq_pwd)) {
				out.println("<script>");
				out.println("alert('비번이 다릅니다!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				File upFile = multi.getFile("cq_file");//수정 첨부된 파일을 가져옴
				if(upFile  != null) {//수정 첨부된 파일이 있는 경우
					String fileName=upFile.getName();//첨부된 파일명을 구함.
					File delFile=new File(saveFolder+db_pwd.getCq_file());//삭제할 파일객체
					//생성
					if(delFile.exists()) {//기존파일이 있다면
						delFile.delete();//기존 첨부파일 삭제
					}
					Calendar c=Calendar.getInstance();
					int year=c.get(Calendar.YEAR);
					int month=c.get(Calendar.MONTH)+1;
					int date=c.get(Calendar.DATE);
					
					String homedir=saveFolder+"/"+year+"-"+month+"-"+date;
					File path01=new File(homedir);
					if(!(path01.exists())) {
						path01.mkdir();//오늘 날짜 폴더 생성
					}
					
					Random r=new Random();
					int random=r.nextInt(100000000);
					
					/*첨부파일 확장자를 구함*/
					int index=fileName.lastIndexOf(".");//마침표 위치번호를 구함
					String fileExtendsion = fileName.substring(index+1);//첨부파일에서 확장자만 구함
					
					String refileName = "file"+year+month+date+random+"."+fileExtendsion;
					//새로운 파일명 구함
					String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;
					//db에 저장될 레코드값
					upFile.renameTo(new File(homedir+"/"+refileName));//실제 업로드
					q.setCq_file(fileDBName);
				}else {//수정 첨부파일이 없는 경우
					String fileDBName="";
					if(db_pwd.getCq_file() != null) {//기존 첨부파일이 있는 경우
						q.setCq_file(db_pwd.getCq_file());
					}else {
						q.setCq_file(fileDBName);
					}
				}//if else

				q.setCq_id(cq_id); q.setCq_title(cq_title);
				q.setCq_pwd(cq_pwd); q.setCq_cont(cq_cont);
				q.setCq_no(cq_no);
				
				this.serviceSv.editQna(q);//자료실 수정
				
				ModelAndView em=new ModelAndView("redirect:/service/service_qcont");
				em.addObject("cq_no",cq_no);
				em.addObject("page",page);
				em.addObject("state","cont");
				return em;
			}		
			return null;
		}
		
		
		
		//1대1문의 삭제
		@RequestMapping("/qna_del_ok") 
		public ModelAndView qna_del_ok(
				@RequestParam("cq_no") int cq_no, int page, @RequestParam("del_pwd")
		String del_pwd, HttpServletResponse response,HttpServletRequest request)
		throws Exception{
	 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			String delFolder=request.getRealPath("upload");
			
			QnaVO db_pwd = this.serviceSv.getQnaCont2(cq_no);
			
			System.out.println(cq_no);
			System.out.println(del_pwd);
			
			
			if(!db_pwd.getCq_pwd().equals(del_pwd)) {
				out.println("<script>");
				out.println("alert('비번이 다릅니다!');");
				out.println("history.go(-1);");
				out.println("</script>");
			}else {
				this.serviceSv.delqna(cq_no);//자료실 삭제
				
				if(db_pwd.getCq_file() != null) {//기존 첨부파일이 있는 경우
					File delFile=new File(delFolder+db_pwd.getCq_file());//삭제할 파일객체
					//생성
					delFile.delete();//폴더는 삭제 안되고,기존 파일만 삭제됨.				
				}
				
				ModelAndView dm=new ModelAndView();
				dm.setViewName("redirect:/service/service_qboard?page="+page);
				return dm;
			}
			return null;
		}
	
}