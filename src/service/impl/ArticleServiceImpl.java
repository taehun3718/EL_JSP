package service.impl;

import java.util.List;

import kr.ktds.kth.model.ArticleModel;
import dao.ArticleDAO;
import service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	//게시판은 로직이 매우 간단하므로 할것이 없심..
	
	private ArticleDAO articleDAO;	//DB단에서 얻은 객체들
	
	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	@Override
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public int writeArticle(ArticleModel article) {
		article.setArticleContent(article.getArticleContent().replaceAll("\n", "<br/>"));
		return articleDAO.writeArticle(article);
	}

	@Override
	public boolean deleteArticle(int id) {
		return articleDAO.deleteArticle(id);
	}

	@Override
	public ArticleModel selectArticle(int id) {
		return articleDAO.selectArticle(id);
	}

	@Override
	public List<ArticleModel> selectAllList() {
		return articleDAO.selectAllList();
	}

	@Override
	public void setArticle(int id) {
	}
}
