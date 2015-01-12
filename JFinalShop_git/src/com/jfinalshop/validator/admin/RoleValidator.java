package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RoleValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("role.name", "errorMessages", "角色名称不允许为空!");
		validateRequiredString("role.value", "errorMessages", "角色标识不允许为空!");		
		validateString("role.value", 6, 20, "errorMessages", "角色标识长度不能小于【6】!");		
		validateRegex("role.value", "^ROLE_.*", "errorMessages", "角色标识必须以ROLE_开头!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}

}
