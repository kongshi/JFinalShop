package com.jfinalshop.validator.admin;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ProductAttributeValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("productAttribute.name", "errorMessages", "商品属性名称不允许为空!");
		validateRequiredString("productAttribute.productType_id", "errorMessages", "商品类型不允许为空!");
		validateRequiredString("attributeType", "errorMessages", "商品属性类型不允许为空!");
		validateRequiredString("productAttribute.isRequired", "errorMessages", "是否必填不允许为空!");
		validateRequiredString("productAttribute.isEnabled", "errorMessages", "是否启用不允许为空!");
		validateRequiredString("productAttribute.orderList", "errorMessages", "排序不允许为空!");
		validateInteger("productAttribute.orderList", 0, 150, "errorMessages", "排序必须为零或正整数!");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("/admin/error.html");
	}
	
}
