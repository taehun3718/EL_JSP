package dao;
import kr.ktds.kth.model.ArticleModel;	//�����ͺ��̽��� �����͸� �ֱ� ���� ArticleModel
import java.util.List;					

public interface ArticleDAO {
	//�Խ����� ������ DB�ܿ��� ������Ʈ
	public void setArticle(int id);
	//�Խ����� ������ DB�ܿ��� ����
	public int writeArticle(ArticleModel article);
	//�Խ����� ������ DB�ܿ��� ����
	public boolean deleteArticle(int id);
	//�Խ����� ���� �� ���� DB�ܿ��� ����
	public ArticleModel selectArticle(int id);
	//�Խ����� ��� ������ DB�ܿ��� ����
	public List<ArticleModel> selectAllList();
}
