package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글상세보기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO notice = new NoticeVO();
		notice.setId(Integer.valueOf(request.getParameter("id")));
		
		notice = noticeDao.noticeSelect(notice);
		request.setAttribute("notice", notice);
		
		return "notice/noticeSelect";
	}

}
