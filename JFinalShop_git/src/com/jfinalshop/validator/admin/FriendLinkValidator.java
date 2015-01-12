package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class FriendLinkValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		c.getFile();
		validateRequiredString("friendLink.name", "errorMessages", "友情链接名称不允许为空!");
		validateUrl("friendLink.url", "errorMessages", "链接地址不合法，请以http://或https://开头!");
		validateRequiredString("friendLink.orderList", "errorMessages", "排序不允许为空!");
		validateInteger("friendLink.orderList", 0, 100, "errorMessages", "排序必须为零或正整数!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
