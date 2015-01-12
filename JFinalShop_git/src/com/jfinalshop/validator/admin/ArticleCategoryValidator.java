package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ArticleCategoryValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("articleCategory.name", "errorMessages", "分类名称不允许为空!");
		validateRequiredString("articleCategory.orderList", "errorMessages", "排序不允许为空!");
		
		validateInteger("articleCategory.orderList", 0, 100, "errorMessages", "排序必须为零或正整数!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}
}
