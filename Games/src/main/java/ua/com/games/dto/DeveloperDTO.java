package ua.com.games.dto;

public class DeveloperDTO {

	private int id;
	private String name;
	
	public DeveloperDTO() {
		// TODO Auto-generated constructor stub
	}

	public DeveloperDTO(int id, String name) {
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
		return "DeveloperDTO [id=" + id + ", name=" + name + "]";
	}
	
}
