package ua.com.games.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	
	@ManyToMany
	@JoinTable(name = "game_offer",
	joinColumns = @JoinColumn(name = "offer_id"),
	inverseJoinColumns = @JoinColumn(name = "game_id"))
	private List<Game> games;
	
	public Offer() {
		// TODO Auto-generated constructor stub
	}
	
	public Offer(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Offer(String name, double price, List<Game> games) {
		super();
		this.name = name;
		this.price = price;
		this.games = games;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Offer [id=" + id + ", name=" + name + ", price=" + price + ", games=" + games + "]";
	}

	

	
}
