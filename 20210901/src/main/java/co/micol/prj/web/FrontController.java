package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.Login;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.Logout;
import co.micol.prj.command.MainCommand;
import co.micol.prj.command.MyInfoEdit;
import co.micol.prj.command.MyInfoUpdate;
import co.micol.prj.command.NoticeDelete;
import co.micol.prj.command.NoticeList;
import co.micol.prj.command.NoticeSelect;
import co.micol.prj.command.NoticeUpdate;
import co.micol.prj.command.NoticeUpdateForm;
import co.micol.prj.command.NoticeWrite;
import co.micol.prj.command.NoticeWriteForm;




@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
   
    public FrontController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/loginForm.do", new LoginForm()); //로그인 폼 호출
		map.put("/login.do", new Login());  //로그인 하기
		map.put("/logout.do", new Logout());  //로그아웃 하기
 		map.put("/myInfoEdit.do", new MyInfoEdit()); //정보 수정하기
		map.put("/myInfoUpdate.do", new MyInfoUpdate()); //실제 정보수정을 실행하는 곳
		map.put("/noticeList.do", new NoticeList()); //게시글 목록 보기
		map.put("/noticeSelect.do", new NoticeSelect()); //게시글 상세보기
		map.put("/noticeDelete.do", new NoticeDelete()); //게시물 삭제하기
		map.put("/noticeWriteForm.do", new NoticeWriteForm()); //글쓰기
		map.put("/noticeWrite.do", new NoticeWrite());  //게시글 저장
		map.put("/noticeUpdate.do", new NoticeUpdate());  //게시물 수정하기
		map.put("/noticeUpdateForm.do", new NoticeUpdateForm()); //게시물 수정 폼 호출
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage +".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
