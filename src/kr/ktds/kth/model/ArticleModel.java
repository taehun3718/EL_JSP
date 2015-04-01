package kr.ktds.kth.model;

public class ArticleModel {
	private int articleId;
	private String articleSubject; 
	private String articleWriter;
	private String articleContent;
	public ArticleModel() {
		super();
	}
	
	public ArticleModel(String articleSubject,
			String articleWriter, String articleContent) {
		super();
		this.articleSubject = articleSubject;
		this.articleWriter = articleWriter;
		this.articleContent = articleContent;
	}
	
	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	public String getArticleSubject() {
		return articleSubject;
	}
	
	public void setArticleSubject(String articleSubject) {
		this.articleSubject = articleSubject;
	}
	
	public String getArticleWriter() {
		return articleWriter;
	}
	
	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}
	
	public String getArticleContent() {
		return articleContent;
	}
	
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
}
