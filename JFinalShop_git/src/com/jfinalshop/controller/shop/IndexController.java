package com.jfinalshop.controller.shop;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinalshop.ext.captcha.CaptchaRender;

/**
 * 前台类 - 首页
 * 
 */
@ControllerBind(controllerKey = "/")
public class IndexController extends Controller{
	
	// 首页
	public void index(){
		redirect("/index.html");
	}
	
	// 验证码
	public void randPic() {
		CaptchaRender img = new CaptchaRender(4); 
		this.setSessionAttr(CaptchaRender.DEFAULT_CAPTCHA_MD5_CODE_KEY, img.getMd5RandonCode());
		render(img);
	}
}
