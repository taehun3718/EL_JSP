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
 * Servlet implementation class doWrite
 */
@WebServlet("/doWrite")
public class doWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doWrite() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		ArticleService articleService = new ArticleServiceImpl();
		ArticleDAO articleDAO = new ArticleDAOImpl();
		
		articleService.setArticleDAO(articleDAO); //contents�� ��� �ִ� \n �ױ׸� <br/> ��ũ�� �ٲ���
		
		//URL : write/ ���� ���� ������� �Ķ���͸� ���� �޾ƿ�
		String articleSubject = request.getParameter("subject");
		String articleWriter  = request.getParameter("writer");
		String articleContent = request.getParameter("content");
		
		ArticleModel articleModel = new ArticleModel(articleSubject, articleWriter, articleContent); //DB�ܿ��� ó���� �����͸� �ʱ�ȭ
		
		articleService.writeArticle(articleModel);//DB�ܿ��� ArticleModel�� ������ writeó��(SQL INSERT)
		response.sendRedirect("./list");
		//RequestDispatcher rd = request.getRequestDispatcher("./list");	//list dispatchcer
		//rd.forward(request, response);								    //URL:list/ �� ������
	}
}
