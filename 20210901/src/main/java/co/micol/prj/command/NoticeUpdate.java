package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//게시글 수정하기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id")));
		vo.setContents(request.getParameter("contents"));
		
		int n =noticeDao.noticeUpdate(vo);  //수정이 일어남

		String page = null;
		if(n != 0) {
			vo = noticeDao.noticeSelect(vo);  //변경된 내용을 불러옴
			request.setAttribute("notice", vo); //변경된 내용을 불러와서 실어보냄
			page = "notice/noticeSelect";  //세부 보여주기 페이지로 리턴
		} else {
			request.setAttribute("message", "수정이 실패했습니다.");
			page = "notice/noticeInsertResult";
		}
		return page;
	}

}
