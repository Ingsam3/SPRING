package net.daum.controller;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import net.daum.service.BbsService;
import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

@Controller //@Controller 애노테이션을 설정함으로써 스프링에서 컨트롤러로 인식한다.
public class BbsController {

	@Autowired
	private BbsService bbsService;

	//자료실 글쓰기 폼
	@GetMapping("/bbs_write") //get으로 접근하는 매핑주소 처리,  bbs_write매핑주소 등록
	public ModelAndView bbs_write(HttpServletRequest request) {
		//페이징에서 내가 본 쪽번호로 바로 이동하는 기능=>책갈피 기능
		int page=1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
			//get으로 전달된 쪽번호가 있는 경우 쪽번호를 정수숫자로 바꿔서 저장
		}

		ModelAndView wm=new ModelAndView();
		wm.addObject("page",page);//페이징 책갈피 기능때문에 page키이름에 쪽번호 저장
		wm.setViewName("bbs/bbs_write");//뷰페이지 경로(뷰리졸브 경로)->/WEB-INF/bbs/bbs_write
		//.jsp
		return wm;
	}//bbs_write()

	//자료실 저장
	@PostMapping("/bbs_write_ok") //post로 접근하는 매핑주소 처리
	public String bbs_write_ok(BbsVO b,HttpServletRequest request) throws 
	Exception{
		String saveFolder=request.getRealPath("upload");
		//이진 파일 업로드 서버 경로            
		int fileSize=5*1024*1024; //이진파일 업로드 최대크기
		MultipartRequest multi=null; //이진파일을 가져올 참조변수

		multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");   

		String bbs_name=multi.getParameter("bbs_name");
		String bbs_title=multi.getParameter("bbs_title");
		String bbs_pwd=multi.getParameter("bbs_pwd");
		String bbs_cont=multi.getParameter("bbs_cont");

		File upFile = multi.getFile("bbs_file");//첨부한 이진파일을 가져온다.

		if(upFile != null) {//첨부한 이진파일이 있는 경우 실행
			String fileName=upFile.getName();//첨부한 파일명
			Calendar cal=Calendar.getInstance();//칼렌더는 추상클래스로 new로 객체 생성을 못함. 년월일 시분초 값을 반환
			int year=cal.get(Calendar.YEAR);//년도값
			int month=cal.get(Calendar.MONTH)+1;//월값, +1을 한 이유는 1월이 0으로 반환 되기 때문에
			int date=cal.get(Calendar.DATE);//일값

			String homedir=saveFolder+"/"+year+"-"+month+"-"+date;//오늘 날짜 폴더 경로 저장
			File path01=new File(homedir);

			if(!(path01.exists())){
				path01.mkdir();//오늘날짜 폴더 생성
			}
			Random r=new Random();//난수를 발생시키는 클래스
			int random=r.nextInt(100000000);//0이상 1억 미만의 정수 숫자 난수 발생

			/*첨부 파일 확장자를 구함*/
			int index=fileName.lastIndexOf(".");//마침표를 맨 오른쪽부터 찾아서 가장 먼저 나오는 .의 위치번호를 맨 왼쪽부터 카운터 해서 반환
			//첫문자는 0부터 시작
			String fileExtendsion=fileName.substring(index+1);//마침표 이후부터 마지막 문자까지 구함.즉 첨부파일 확장자를 구함.
			String refileName="bbs"+year+month+date+random+"."+fileExtendsion;//새로운 파일명 저장
			String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;//데이터베이스에 저장될 레코드값
			upFile.renameTo(new File(homedir+"/"+refileName));//생성된 폴더에 변경된 파일명으로 실제 업로드

			b.setBbs_file(fileDBName);
		}else {//첨부파일이 없는 경우
			String fileDBName="";
			b.setBbs_file(fileDBName);
		}
		b.setBbs_name(bbs_name); b.setBbs_title(bbs_title);
		b.setBbs_pwd(bbs_pwd); b.setBbs_cont(bbs_cont);

		this.bbsService.insertBbs(b);//자료실 저장

		return "redirect:/bbs_list";//자료실 목록보기로 매핑주소가 이동
	}//bbs_write_ok()

	//페이징과 검색기능이 되는 자료실 목록
	@RequestMapping("/bbs_list")
	public ModelAndView bbs_list(HttpServletRequest request,BbsVO b,PageVO p) {

		int page=1;
		int limit=10;//한페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
			//페이지번호를 정수숫자로 변경해서 저장         
		}

		 /* 검색과 관련된 부분 */
		 String find_name=request.getParameter("find_name");//검색어
		 String find_field=request.getParameter("find_field");//검색 필드
		 p.setFind_name("%"+find_name+"%");//sql문에서 %와일드 카드 문자는 하나이상의 임의의 모르는
		 //문자와 매핑 대응
		 p.setFind_field(find_field);
		
		int totalCount=this.bbsService.getRowCount(p);
		//검색전 총레코드 개수,검색후 레코드 개수

		p.setStartrow((page-1)*10+1);//시작행번호
		p.setEndrow(p.getStartrow()+limit-1);//끝행 번호

		List<BbsVO> blist=this.bbsService.getBbsList(p); //검색 전후 목록

		//총 페이지수
		int maxpage=(int)((double)totalCount/limit+0.95);
		//시작페이지(1,11,21 ..)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage=maxpage;
		if(endpage>startpage+10-1) endpage=startpage+10-1;

		ModelAndView  listM=new ModelAndView("./bbs/bbs_list");//생성자 인자값으로 뷰페이지
		//경로 설정=> /WEB-INF/bbs/bbs_list.jsp
		
		listM.addObject("blist",blist);//blist문자열 속성 키이름에 자료실 목록을 저장
        listM.addObject("page",page);//쪽번호
        listM.addObject("startpage",startpage);//시작페이지
        listM.addObject("endpage",endpage);//마지막 페이지
        listM.addObject("maxpage",maxpage);//최대 페이지
        listM.addObject("listcount",totalCount);//검색전후 레코드 개수
        listM.addObject("find_field", find_field);//검색 필드
        listM.addObject("find_name", find_name);//검색어
        
		return listM;
	}//bbs_list()
	
	//자료실 내용보기+답변폼+수정폼+삭제폼
	@RequestMapping("/bbs_cont")
	public ModelAndView bbs_cont(int bbs_no, String state, int page, BbsVO b) {
		if(state.equals("cont")) {//내용보기 일 때 만 조회수 증가
			b=this.bbsService.getBbsCont(bbs_no);
		}else {//답변폼, 수정폼, 삭제폼일 때는 조회 수 증가 안 시킨다
			b=this.bbsService.getBbsCont2(bbs_no);
		}
		String bbd_cont = b.getBbs_cont().replace("\n", "<br>");
		//textarea 입력박스에서 엔터키 친 부분은 웹상에서 볼 떄 줄바꿈한다
		ModelAndView cm = new ModelAndView();
		cm.addObject("page",page); //페이징에서 책갈피 기능 때문에 쪽번호 저장
		cm.addObject("b",b); 
		cm.addObject("bbs_cont",b); 
		
		if(state.equals("cont")) {
			cm.setViewName("./bbs/bbs_cont");
		}else if(state.equals("reply")){//답변폼일 때
			cm.setViewName("./bbs/bbs_reply");
		}else if(state.equals("edit")){//수정폼일 떄
			cm.setViewName("./bbs/bbs_edit");
		}else if(state.equals("del")){//삭제폼일 떄
			cm.setViewName("./bbs/bbs_del");
		}

		
		return cm;
	}
}






