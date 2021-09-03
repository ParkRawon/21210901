package co.micol.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 목록 보기
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = noticeDao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		return "notice/noticeList";
	}

}
