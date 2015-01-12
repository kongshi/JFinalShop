package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ProductTypeValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("productType.name", "errorMessages", "商品类型不允许为空!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
