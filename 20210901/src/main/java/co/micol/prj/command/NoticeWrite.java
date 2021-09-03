package co.micol.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeWrite implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO notice = new NoticeVO();
		notice.setWriter(request.getParameter("writer"));
		notice.setWriteDate(Date.valueOf(request.getParameter("writeDate")));
		notice.setTitle(request.getParameter("title"));
		notice.setContents(request.getParameter("contents"));
		
		int n = noticeDao.noticeInsert(notice);
		
		if(n != 0) {
			request.setAttribute("message", "정상적으로 입력이 완료되었다.");
		} else {
			request.setAttribute("message", "글쓰기를 실패하였습니다");
		}
		return "notice/noticeInsertResult";
	}

}
