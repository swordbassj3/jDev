package org.hdcd.board;

import java.util.List;

import org.hdcd.board.Board;

@SuppressWarnings("unused") //사용하지 않는 코드에 대한 경고 숨
public interface BoardService {
	
	public void register(Board board) throws Exception;
	
	public List<Board> selectList(int page, int pageSize) throws Exception;

	public int getTotalCount() throws Exception;
	
	public Board selectOne(int boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(int boardNo) throws Exception;
	
	public void viewCount(int boardNo) throws Exception;

}
