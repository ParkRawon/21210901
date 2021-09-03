package co.micol.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 처음 접근하는 페이지
		//공지사항 리스트를 가져오는 것을 만들어 준다.
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = noticeDao.noticeSelectList();
		
		request.setAttribute("notices", list);
		
		
		return "member/loginForm";  
	}

}
