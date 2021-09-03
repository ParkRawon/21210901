package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MyInfoUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//실제 정보수정을 실행하는 곳, 변경된 값 저장하는 메소드
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setAuth(request.getParameter("auth"));
		
		int n = memberDao.memberUpdate(member);
		if(n != 0 ) {
			request.setAttribute("message", "정상적으로 수정되었다");
		}else {
			request.setAttribute("message", "회원정보 수정이 실패 했다아아");
		}
		return "member/memberEditResult";
	}

}
