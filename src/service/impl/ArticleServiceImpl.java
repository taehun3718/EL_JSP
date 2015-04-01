package service.impl;

import java.util.List;

import kr.ktds.kth.model.ArticleModel;
import dao.ArticleDAO;
import service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	//�Խ����� ������ �ſ� �����ϹǷ� �Ұ��� ����..
	
	private ArticleDAO articleDAO;	//DB�ܿ��� ���� ��ü��
	
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
