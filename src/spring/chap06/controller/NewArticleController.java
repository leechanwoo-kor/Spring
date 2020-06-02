package spring.chap06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.chap06.service.ArticleService;
import spring.chap06.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
		// /WEB-INF/view/article/newArticleForm.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		//command.getTitle() : title 파라미터 값 저장
		//command.getContent() : content 파라미터 값 저장
		//command.getParentId() : parentId 파라미터 값 저장
		return "article/newArticleSubmitted";
	}
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
