package ua.com.games.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.games.entity.Client;
import ua.com.games.entity.Developer;
import ua.com.games.entity.Game;
import ua.com.games.entity.Genre;
import ua.com.games.entity.Offer;

public class DtoUtilMapper {

	public static List<GameDTO> gamesToGamesDTO(List<Game> games) {

		List<GameDTO> gameDTOs = new ArrayList<GameDTO>();

		for (Game game : games) {

			GameDTO gameDTO = new GameDTO();

			gameDTO.setId(game.getId());
			gameDTO.setName(game.getName());
			gameDTO.setYear(game.getYear());

			gameDTOs.add(gameDTO);
		}

		return gameDTOs;
	}

	public static List<DeveloperDTO> developersToDevelopersDTO(List<Developer> developers) {

		List<DeveloperDTO> developerDTOs = new ArrayList<DeveloperDTO>();

		for (Developer developer : developers) {

			DeveloperDTO developerDTO = new DeveloperDTO();

			developerDTO.setId(developer.getId());
			developerDTO.setName(developer.getName());

			developerDTOs.add(developerDTO);
		}

		return developerDTOs;
	}

	public static List<ClientDTO> clientsToClientsDTO(List<Client> clients) {

		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();

		for (Client client : clients) {

			ClientDTO clientDTO = new ClientDTO();

			clientDTO.setId(client.getId());
			clientDTO.setName(client.getName());
			clientDTO.setEmail(client.getEmail());
			clientDTO.setPathImage(client.getPathImage());

			clientDTOs.add(clientDTO);
		}

		return clientDTOs;

	}

	public static ClientDTO clientToClientDTO(Client client) {

		ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getEmail(), client.getPathImage());

		return clientDTO;
	}

	public static List<GenreDTO> genresToGenresDTO(List<Genre> genres) {

		List<GenreDTO> genreDTOs = new ArrayList<GenreDTO>();

		for (Genre genre : genres) {

			GenreDTO genreDTO = new GenreDTO();

			genreDTO.setId(genre.getId());
			genreDTO.setName(genre.getName());

			genreDTOs.add(genreDTO);
		}

		return genreDTOs;
	}

	public static GameDTO gameToGameDTO(Game game) {

		GameDTO gameDTO = new GameDTO(game.getId(), game.getName(), game.getYear());

		return gameDTO;
	}

	public static List<OfferDTO> offersToOffersDTO(List<Offer> offers) {

		List<OfferDTO> offerDTOs = new ArrayList<>();

		for (Offer offer : offers) {

			OfferDTO offerDTO = new OfferDTO(offer.getId(), offer.getName(), offer.getPrice(), offer.getGames());

			offerDTOs.add(offerDTO);
		}

		return offerDTOs;
	}

	public static Developer developerDTOToDeveloper(DeveloperDTO developerDTO) {

		Developer developer = new Developer(developerDTO.getName());

		return developer;
	}

	public static Genre genreDTOToGenre(GenreDTO genreDTO) {

		Genre genre = new Genre(genreDTO.getName());

		return genre;
	}

	public static Game gameDTOToGame(GameDTO gameDTO) {

		Game game = new Game(gameDTO.getName(), gameDTO.getYear());

		return game;
	}
	
	public static Offer offerDTOToOffer(OfferDTO offerDTO){
		
		Offer offer = new Offer(offerDTO.getName(), offerDTO.getPrice());
		
		return offer;
	}
	
}
