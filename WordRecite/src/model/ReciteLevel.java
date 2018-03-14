package model;

import java.util.HashMap;
import java.util.Map;

public enum  ReciteLevel {
	INRECOGNIZED,KNOWLITTLE,KNOWMAJORITY,KNOWALL;
	public static Map toMap(){	
		int i=0;
		Map <Integer,String>map=new HashMap<>();
		for( ReciteLevel s:ReciteLevel.values()){
			map.put(++i, s.toString());
		}
		return map;
//		System.out.println(map.keySet());
//		System.out.println(map.values());
	}
	public static void main(String[] args) {
		ReciteLevel.toMap();
	}
}

