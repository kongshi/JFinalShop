package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ArticleValidator extends Validator{
	
	@Override
	protected void validate(Controller c) {
		validateRequiredString("article.title", "errorMessages", "标题不允许为空!");
		validateRequiredString("article.articleCategory_id", "errorMessages", "文章分类不允许为空!");
		validateRequiredString("article.content", "errorMessages", "文章内容不允许为空!");
		
		validateRequiredString("article.isPublication", "errorMessages", "是否发布不允许为空!");
		validateRequiredString("article.isTop", "errorMessages", "是否置顶不允许为空!");
		validateRequiredString("article.isRecommend", "errorMessages", "是否推荐不允许为空!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
