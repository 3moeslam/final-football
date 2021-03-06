package com.sparrow.eslam.footballfinal.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Competition {

	@SerializedName("numberOfGames")
	private int numberOfGames;

	@SerializedName("lastUpdated")
	private String lastUpdated;

	@SerializedName("currentMatchday")
	private int currentMatchday;

	@Ignore
	@SerializedName("_links")
	private Links links;

	@SerializedName("year")
	private String year;

	@SerializedName("league")
	private String league;

	@SerializedName("caption")
	private String caption;

	@PrimaryKey
	@SerializedName("id")
	private int id;

	@SerializedName("numberOfTeams")
	private int numberOfTeams;

	@SerializedName("numberOfMatchdays")
	private int numberOfMatchdays;

	public void setNumberOfGames(int numberOfGames){
		this.numberOfGames = numberOfGames;
	}

	public int getNumberOfGames(){
		return numberOfGames;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setCurrentMatchday(int currentMatchday){
		this.currentMatchday = currentMatchday;
	}

	public int getCurrentMatchday(){
		return currentMatchday;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setLeague(String league){
		this.league = league;
	}

	public String getLeague(){
		return league;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNumberOfTeams(int numberOfTeams){
		this.numberOfTeams = numberOfTeams;
	}

	public int getNumberOfTeams(){
		return numberOfTeams;
	}

	public void setNumberOfMatchdays(int numberOfMatchdays){
		this.numberOfMatchdays = numberOfMatchdays;
	}

	public int getNumberOfMatchdays(){
		return numberOfMatchdays;
	}

	@Override
 	public String toString(){
		return 
			"Competition{" +
			"numberOfGames = '" + numberOfGames + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",currentMatchday = '" + currentMatchday + '\'' + 
			",_links = '" + links + '\'' + 
			",year = '" + year + '\'' + 
			",league = '" + league + '\'' + 
			",caption = '" + caption + '\'' + 
			",id = '" + id + '\'' + 
			",numberOfTeams = '" + numberOfTeams + '\'' + 
			",numberOfMatchdays = '" + numberOfMatchdays + '\'' + 
			"}";
		}
}