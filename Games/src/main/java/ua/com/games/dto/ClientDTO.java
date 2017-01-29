package ua.com.games.dto;

public class ClientDTO {

	private int id;
	private String name;
	private String email;
	private String pathImage;
	
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClientDTO(int id, String name, String email, String pathImage) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pathImage = pathImage;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", name=" + name + ", email=" + email + ", pathImage=" + pathImage + "]";
	}

	
	
}
