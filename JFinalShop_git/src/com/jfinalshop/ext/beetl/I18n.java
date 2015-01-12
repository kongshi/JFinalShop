package com.jfinalshop.ext.beetl;

import javax.servlet.http.HttpServletRequest;

import org.beetl.core.Context;
import org.beetl.core.Function;

import com.jfinal.i18n.I18N;

public class I18n implements Function {
	
	public Object call(Object[] obj, Context context) {
		HttpServletRequest req = (HttpServletRequest) context.getGlobal("request");
		try {
			return I18N.getText((String) obj[0], req.getLocale());
		} catch (NullPointerException e) {
			return I18N.getText((String) obj[0]);
		}
	}

}
