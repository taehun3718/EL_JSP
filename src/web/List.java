package web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import service.ArticleService;
import service.impl.ArticleServiceImpl;
import kr.ktds.kth.model.ArticleModel;
/**
 * Servlet implementation class List
 */
@WebServlet("/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleService articleService = new ArticleServiceImpl(); //db단 서비스를 위한
		ArticleDAO articleDAO = new ArticleDAOImpl();			  //db단 제어를 위한 IMPL 된 객체 삽입
		articleService.setArticleDAO(articleDAO);
		
		java.util.List<ArticleModel> articleList =  articleService.selectAllList();//db단에서 모든 데이터를 불러옴
		
		request.setAttribute("articleList", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
