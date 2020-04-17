package kr.co.openeg.lab.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.openeg.lab.board.model.BoardCommentModel;
import kr.co.openeg.lab.board.model.BoardModel;

@Repository
public class BoardDaoImpl implements BoardDao {

	private HashMap<String, Object> valueMap = new HashMap<String, Object>();

	@Autowired
	SqlSessionTemplate ss;

	public List<BoardModel> selectBoardList(int startArticleNum, int endArticleNum) {
		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);
		return ss.selectList("board.getBoardList", valueMap);
	}

	public BoardModel selectOneArticle(int idx) {
		return (BoardModel) ss.selectOne("board.getOneArticle", idx);
	}

	public List<BoardModel> selectArticle(String type, String keyword, int startArticleNum, int endArticleNum) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);
		return ss.selectList("board.searchArticle", valueMap);
	}

	public List<BoardCommentModel> selectCommentList(int idx) {
		return ss.selectList("board.getCommentList", idx);
	}

	public void insertArticle(BoardModel board) {
		ss.insert("board.writeArticle", board);
	}

	public void insertComment(BoardCommentModel comment) {
		ss.insert("board.writeComment", comment);
	}

	public void updateHitcount(int hitcount, int idx) {
		valueMap.put("hitcount", hitcount);
		valueMap.put("idx", idx);
		ss.update("board.updateHitcount", valueMap);
	}

	public void updateRecommendCount(int recommendcount, int idx) {
		valueMap.put("recommendcount", recommendcount);
		valueMap.put("idx", idx);
		ss.update("board.updateRecommendcount", valueMap);

	}

	public int selectTotalNum() {
		return (Integer) ss.selectOne("board.getTotalNum");
	}

	public int selectSearchTotalNum(String type, String keyword) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);

		return (Integer) ss.selectOne("board.getSearchTotalNum", valueMap);
	}

	public void deleteComment(int idx) {
		ss.delete("board.deleteComment", idx);
	}

	public void deleteArticle(int idx) {
		ss.delete("board.deleteArticle", idx);
	}

	public BoardCommentModel selectOneComment(int idx) {

		return (BoardCommentModel) ss.selectOne("board.getOneComment", idx);
	}

	public void updateArticle(BoardModel board) {
		ss.update("board.modifyArticle", board);
	}

}
