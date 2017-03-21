package test;

import com.online.domain.*;
import com.online.dao.*;

public class TestDAO {
	public static void main(String[] args) {
		/*Writer w = new Writer(15,"123","123","123","123","123","123");
		WriterDAO wd = new WriterDAO();
		System.out.println(wd.getAllWriter());
		wd.getWriterByID(1230);
		System.out.println(wd);*/
		
		ArticleDAO ad = new ArticleDAO();
		System.out.println(ad.getAllArticleByReviewerID(123456));
	}
}
