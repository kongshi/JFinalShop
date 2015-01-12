package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class NavigationValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("navigation.name", "errorMessages", "导航名称不允许为空!");
		validateRequiredString("navigation.url", "errorMessages", "链接地址不允许为空!");
		validateRequiredString("navigation.orderList", "errorMessages", "排序不允许为空!");
		validateRequiredString("navigation.isVisible", "errorMessages", "是否显示不允许为空!");
		validateRequiredString("navigation.isBlankTarget", "errorMessages", "在新窗口中打开不允许为空!");
		
		validateInteger("navigation.orderList", 0, 100, "errorMessages", "排序必须为零或正整数!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
