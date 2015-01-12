package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class BrandValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		c.getFile();
		validateRequiredString("brand.name", "errorMessages", "品牌名称不允许为空!");
		validateUrl("brand.url", "errorMessages", "网址格式错误!");
		validateRequiredString("brand.orderList", "errorMessages", "排序不允许为空!");
		
		validateInteger("brand.orderList", 0, 100, "errorMessages", "排序必须为零或正整数!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}
}
