package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MyInfoEdit implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//자신의 정보를 수정
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession();  //세션객체 가지고 오기
		member.setId((String)session.getAttribute("id"));  //세션이 가지고 있는 사용자 id
		
		member = memberDao.memberSelect(member);
		request.setAttribute("member", member);
		return "member/memberInfo";
		
	}

}
