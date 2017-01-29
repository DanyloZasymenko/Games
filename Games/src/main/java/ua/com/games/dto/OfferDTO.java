package ua.com.games.dto;

import java.util.List;

import ua.com.games.entity.Game;

public class OfferDTO {

	private int id;
	private String name;
	private double price;
	private List<Game> games;
	
	public OfferDTO() {
		// TODO Auto-generated constructor stub
	}

	public OfferDTO(int id, String name, double price, List<Game> games) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.games = games;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "OfferDTO [id=" + id + ", name=" + name + ", price=" + price + ", games=" + games + "]";
	}

	
}
