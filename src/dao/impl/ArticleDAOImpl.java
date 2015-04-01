package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ktds.kth.model.ArticleModel;
import dao.ArticleDAO;

public class ArticleDAOImpl implements ArticleDAO{

	@Override
	public void setArticle(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int writeArticle(ArticleModel article) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KTH","3278");
			
			String sql = " INSERT INTO ARTICLE_BOARD(ARTICLE_ID,ARTICLE_SUBJECT,ARTICLE_WRITER,ARTICLE_CONTENT) VALUES(BOARD_INDEX_SEQ.NEXTVAL ,?,?,?) ";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, article.getArticleSubject());
			stmt.setString(2, article.getArticleWriter());
			stmt.setString(3, article.getArticleContent());
			stmt.execute();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException sqle){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sqle){}
			}
			
		}
		return article.getArticleId();
	}

	@Override
	public boolean deleteArticle(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KTH","3278");
			
			String sql = " DELETE FROM ARTICLE_BOARD WHERE ARTICLE_ID = ? ";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException sqle){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sqle){}
			}
		}
		return true;
	}

	@Override
	public ArticleModel selectArticle(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArticleModel article = new ArticleModel();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KTH","3278");
			
			String sql = " SELECT ARTICLE_ID,ARTICLE_SUBJECT,ARTICLE_WRITER,ARTICLE_CONTENT FROM ARTICLE_BOARD WHERE ARTICLE_ID = ? ";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			
			if(rs.next()){
				article.setArticleId(rs.getInt(1));
				article.setArticleSubject(rs.getString(2));
				article.setArticleWriter(rs.getString(3));
				article.setArticleContent(rs.getString(4));
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException sqle){}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException sqle){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sqle){}
			}
		}
		return article;
	}

	@Override
	public List<ArticleModel> selectAllList() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleModel> articleModel = new ArrayList<ArticleModel>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KTH","3278");
			
			String sql = "SELECT  " +
					"ARTICLE_ID " +
					",ARTICLE_WRITER " +
					", ARTICLE_SUBJECT " +
					", ARTICLE_CONTENT " +
					"FROM KTH.ARTICLE_BOARD ";

			
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();	
			ArticleModel am = null;
			while(rs.next()){
				am = new ArticleModel();
				
				am.setArticleId(rs.getInt(1));
				am.setArticleWriter(rs.getString(2));
				am.setArticleSubject(rs.getString(3));
				am.setArticleContent(rs.getString(4));
				articleModel.add(am);
				
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException sqle){}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException sqle){}
			}
			
		}
		return articleModel;
	}
	
}