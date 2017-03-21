package test;

import com.online.domain.Page;
import com.online.domain.Reviewer;
import com.online.service.*;
public class TestPage {
	
	
	public static void main(String[] args) {
		Page<Reviewer> page = new ReviewerService().getPage(1);
		for(Reviewer r:page.getList()){
			System.out.println(r.getReviewerID());
		}
		System.out.println(page.getTotalRecord());
	}
}
