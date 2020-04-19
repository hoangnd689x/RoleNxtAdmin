package com.orgchart.orgchart.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public List<Long> ListStringToListLong(String listStr){
		
		String[] strs = listStr.split(",");
		
		List<Long> listLong = new ArrayList<Long>();
		
		for(String s : strs) {
			listLong.add(Long.valueOf(s));
		}
		return listLong;
	}

}
