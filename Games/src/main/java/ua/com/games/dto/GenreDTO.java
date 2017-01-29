package ua.com.games.dto;

public class GenreDTO {

	private int id;
	private String name;
	
	public GenreDTO() {
		// TODO Auto-generated constructor stub
	}

	public GenreDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "GenreDTO [id=" + id + ", name=" + name + "]";
	}
	
}
