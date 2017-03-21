package test;

import java.util.List;

import com.online.dao.ArticleDAO;
import com.online.domain.Article;

public class Ytest {
	public static void main(String[] args) {
		List<Article> list = new ArticleDAO().getAllArticleByReviewerID(123456);
		for(Article a:list){
			System.out.println(a.getArticleID()+"  " +a.getTitle()+ "  " + a.getA_abstract());
		}
	}
}
