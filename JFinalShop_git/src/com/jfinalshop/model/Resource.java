package com.jfinalshop.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

/**
 * 实体类 - 资源
 * 
 */
public class Resource extends Model<Resource>{

	private static final long serialVersionUID = 7906172672735389314L;
	
	public static final Resource dao = new Resource();
	
	/**
	 * 获得所有资源
	 * @return
	 */
	public List<Resource> getAll(){
		return dao.find("select * from resource");		
	}

}
