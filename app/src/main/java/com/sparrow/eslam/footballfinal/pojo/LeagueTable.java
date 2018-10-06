package com.sparrow.eslam.footballfinal.pojo;

import com.google.gson.annotations.SerializedName;

public class LeagueTable{

	@SerializedName("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"LeagueTable{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}