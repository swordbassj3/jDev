package org.hdcd.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hdcd.board.Board;
import org.hdcd.board.BoardMapper;


import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


@SuppressWarnings("unused")
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper mapper; 
	
	@Override
	public void register(Board board) throws Exception{
		mapper.insert(board);
	}
	
	@Override
	public List<Board> selectList(int page, int pageSize) throws Exception{
		 if (page < 1) page = 1;
		    if (pageSize < 1) pageSize = 2;

		    int offset = (page - 1) * pageSize;

		    return mapper.selectList(offset, pageSize);
	}
	
	@Override
	public int getTotalCount() throws Exception{
		Integer cnt = mapper.selectCount();
	    return (cnt == null) ? 0 : cnt;
	}
	
	@Override
	public Board selectOne(int boardNo) throws Exception{
		return mapper.selectOne(boardNo);
	}
	
	@Override
	public void update(Board board) throws Exception{
		mapper.update(board);
	}
	
	@Override
	public void delete(int boardNo) throws Exception{
		mapper.delete(boardNo);
	}
	
	@Override
	public void viewCount(int boardNo) throws Exception{
		mapper.viewCnt(boardNo);
	}
}