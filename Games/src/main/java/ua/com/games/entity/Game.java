package ua.com.games.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int year;

	@ManyToMany
	@JoinTable(name = "game_genre", 
	joinColumns = @JoinColumn(name = "game_id"), 
	inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;
	
	@ManyToMany
	@JoinTable(name = "game_order", 
	joinColumns = @JoinColumn(name = "game_id"), 
	inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Orders> orders;

	@ManyToOne
	@JoinColumn(name = "developer_id")
	private Developer developer;

	@ManyToMany
	@JoinTable(name = "game_offer",
	joinColumns = @JoinColumn(name = "game_id"),
	inverseJoinColumns = @JoinColumn(name = "offer_id"))
	private List<Offer> offers;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(String name, int year) {
		super();
		this.name = name;
		this.year = year;
	}

	public Game(String name, int year, List<Genre> genres, Developer developer) {
		super();
		this.name = name;
		this.year = year;
		this.genres = genres;
		this.developer = developer;
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

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", year=" + year + ", genres=" + genres + ", orders=" + orders
				+ ", developer=" + developer + ", offers=" + offers + "]";
	}

	
	
}
