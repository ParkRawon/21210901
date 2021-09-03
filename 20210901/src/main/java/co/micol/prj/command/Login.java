package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//로그인 하기 
		MemberService memberDao = new MemberServiceImpl(); //모델을 호출
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession(); //서버가 가지고 있는 session객체를 불러온다.
		
		member.setId(request.getParameter("id"));  //""-> form이 가지고 있는 name변수
		member.setPassword(request.getParameter("password"));
		
		member = memberDao.memberLogin(member);
		
		String message = null;
		String page = null;
		
		if(member.getName() != null) {
			//성공시 돌려줄 페이지 (성공시 세션에 담는다)
			page = "member/loginResult";
			session.setAttribute("id", member.getId());
			session.setAttribute("password", member.getPassword()); //세션객체에 아이디와 권한을 담는다.
			session.setAttribute("auth", member.getAuth());
			session.setAttribute("name", member.getName()); 
		} else {
			//실패시 돌려줄 페이지
			page = "member/loginFail";
			message = member.getId() + "는 존재하지 않거나 패스워드가 틀렸습니다.";
			request.setAttribute("message", message);
		}
		
		
		return page;  //성공 or 실패에 따른 페이지
	}

}
