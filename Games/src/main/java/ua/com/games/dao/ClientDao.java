package ua.com.games.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.games.entity.Client;
import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;

public interface ClientDao extends JpaRepository<Client, Integer> {

	Client findByName(String name);

	Client findByEmail(String email);

	@Query("select c from Client c where c.uuid =:uuid")
	Client findByUUID(@Param("uuid") String uuid);
	
//	@Query("select g from Game g where g.id in(select game_id from game_offer go where offer_id in(select offer_id from orders o where client_id = 1))")
//	List<Game> findGamesByClient();
//	
	// @Query("select distinct c from Client c left join fetch c.games where
	// c.id =:id")
	// void fetchClientWithGames(@Param("id") int id);
}
