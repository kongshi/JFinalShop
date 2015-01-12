package com.jfinalshop.validator.admin;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;
import com.jfinalshop.model.ProductCategory;

public class ProductCategoryValidator extends Validator{

	private List<String> errorMessageList;
	@Override
	protected void validate(Controller c) {		
		
		errorMessageList = new ArrayList<String>();
		ProductCategory productCategory = c.getModel(ProductCategory.class);
		if(StrKit.isBlank(productCategory.getStr("name"))){
			errorMessageList.add("分类名称不允许为空!");
		}
						
		if(productCategory.getInt("orderList") < 0 ){
			errorMessageList.add("排序不允许为空!");
		}
		
		int temp = productCategory.getInt("orderList");
		if (temp < 1 || temp > 1000){
			errorMessageList.add("排序必须为零或正整数!");
		}
		
		
		if(0 < errorMessageList.size()){
			addError("errorMessage", "您的操作出现错误!");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.setAttr("errorMessages", errorMessageList);
		c.setAttr("redirectionUrl", "/productCategory/input");
		c.render("/admin/error.html");
	}
	
}
