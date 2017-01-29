package ua.com.games.dto;

import java.util.List;

import ua.com.games.entity.Developer;
import ua.com.games.entity.Genre;

public class GameDTO {

	private int id;
	private String name;
	private int year;
	private List<Genre> genres;
	private Developer developer;

	public GameDTO() {
		// TODO Auto-generated constructor stub
	}

	public GameDTO(int id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "GameDTO [id=" + id + ", name=" + name + ", year=" + year + ", genres=" + genres + ", developer="
				+ developer + "]";
	}
	
}
