package service;

import java.util.List;

import dao.ArticleDAO;
import kr.ktds.kth.model.ArticleModel;

public interface ArticleService {
	//Logic´Ü Service
	
	public void setArticle(int id);
	public int writeArticle(ArticleModel article);
	public boolean deleteArticle(int id);
	public ArticleModel selectArticle(int id);
	public List<ArticleModel> selectAllList();
	public ArticleDAO getArticleDAO();
	public void setArticleDAO(ArticleDAO articleDAO);
}