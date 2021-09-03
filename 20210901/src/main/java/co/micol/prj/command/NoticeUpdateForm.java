package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 수정할 수 있는 폼 호출
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id")));
		
		vo = noticeDao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeUpdateForm";
	}

}
