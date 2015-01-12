package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.jfinalshop.model.Admin;

public class AdminValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("admin.username", "errorMessages", "用户名不允许为空!");		
		validateRequiredString("admin.email", "errorMessages", "E-mail不允许为空!");
		validateRequiredString("admin.isAccountEnabled", "errorMessages", "是否启用不允许为空!");		
		validateString("admin.username", 2, 20, "errorMessages", "用户名长度必须在【2】到【20】之间!");		
		validateEmail("admin.email", "errorMessages", "E-mail格式错误!");		
        validateRegex("admin.username", "^[0-9a-z_A-Z\u4e00-\u9fa5]+$", "errorMessages", "用户名只允许包含中文、英文、数字和下划线!");
        // 更新为空不更新密码
        String actionKey = getActionKey();	
        if (!actionKey.equals("/admin/update")) {
			validateRequiredString("admin.password", "errorMessages", "密码不允许为空!");
			validateEqualField("admin.password", "rePassword", "errorMessages", "两次密码输入不一致!");
			validateString("admin.password", 4, 20, "errorMessages", "密码长度必须在【4】到【20】之间!");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(Admin.class);
		c.render("/admin/error.html");
	}
}
