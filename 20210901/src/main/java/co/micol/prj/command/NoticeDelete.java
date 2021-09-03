package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 삭제하기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO notice = new NoticeVO();
		notice.setId(Integer.valueOf(request.getParameter("id")));
		
		int n = noticeDao.noticeDelete(notice);
		
		if(n != 0) {
			request.setAttribute("message", "정상적으로 삭제되었습니다");
		}else {
			request.setAttribute("message", "삭제를 실패하였습니다");
		}
		return "notice/noticeInsertResult";
	}

}
