package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;

public class NoticeWriteForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글쓰기 입력 폼만 호출
		return "notice/noticeWriteForm";
	}

}
