package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.micol.prj.comm.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;


public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 세부정보 보기
		String sql = "select * from member where id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAuth(rs.getString("auth"));
				vo.setAddress(rs.getString("address"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원정보 수정
		int n = 0;
		String sql = "update member set password=?, name=?, address=?, auth=? where id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getPassword());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getAddress());
			psmt.setString(4, vo.getAuth());
			psmt.setString(5, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		//회원정보 삭제
		int n = 0;
		String sql = "delete from member where id=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
		return n;
	}

	@Override
	public boolean isIdCheck(String str) {
		//아이디 중복체크
		return false;
	}

	
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// 로그인
		String sql = "select * from member where id=? and password=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) { //존재하면
				vo.setName(rs.getString("name"));
				vo.setAuth(rs.getString("auth"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
