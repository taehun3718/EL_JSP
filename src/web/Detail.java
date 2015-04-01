package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ktds.kth.model.ArticleModel;
import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import service.ArticleService;
import service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArticleService articleService = new ArticleServiceImpl();
		ArticleDAO articleDAO = new ArticleDAOImpl();
		articleService.setArticleDAO(articleDAO);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ArticleModel articleModel = articleService.selectArticle(id);
		request.setAttribute("viewDetail", articleModel);
		
		List<String> options = new ArrayList<String>();
		
		List<String> checkBoxes = new ArrayList<String>();
		for(int i=0; i<20; i++){
			checkBoxes.add("Check Box " + i);
		}
		
		options.add("����");
		options.add("����");
		options.add("������");
		options.add("��õ");
		options.add("��õ");
		
		request.setAttribute("cities", options);
		request.setAttribute("region", "��õ");
		request.setAttribute("checkBoxes", checkBoxes);
		
		//DB�ܿ��� üũ�ڽ��� �����Դٰ� ����
		
		List<String> checkedList = new ArrayList<String>();
		
		checkedList.add("Check Box 5");
		checkedList.add("Check Box 10");
		checkedList.add("Check Box 11");
		checkedList.add("Check Box 19");
		
		request.setAttribute("checkedList", checkedList);
		
		HttpSession session = request.getSession();
		session.setAttribute("_MEMBER_", articleModel);
		
		RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
		rd.forward(request, response);

	}

}
