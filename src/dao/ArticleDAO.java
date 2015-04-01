package dao;
import kr.ktds.kth.model.ArticleModel;	//데이터베이스에 데이터를 넣기 위한 ArticleModel
import java.util.List;					

public interface ArticleDAO {
	//게시판의 내용을 DB단에서 업데이트
	public void setArticle(int id);
	//게시판의 내용을 DB단에서 쓰기
	public int writeArticle(ArticleModel article);
	//게시판의 내용을 DB단에서 삭제
	public boolean deleteArticle(int id);
	//게시판의 내용 한 개를 DB단에서 선택
	public ArticleModel selectArticle(int id);
	//게시판의 모든 내용을 DB단에서 선택
	public List<ArticleModel> selectAllList();
}
