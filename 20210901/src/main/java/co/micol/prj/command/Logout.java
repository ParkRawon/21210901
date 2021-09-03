package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession();
		session.invalidate();  //세션전체 삭제
		return "main.do";
	}

}
