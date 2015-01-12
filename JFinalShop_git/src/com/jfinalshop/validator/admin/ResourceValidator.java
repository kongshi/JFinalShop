package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ResourceValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("resource.name", "errorMessages", "资源名称不允许为空!");
		validateRequiredString("resource.value", "errorMessages", "资源值不允许为空!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
