package ua.com.games.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;

public interface OfferDao extends JpaRepository<Offer, Integer>{
	
//	@Query("select * from game where id in(select game_id from game_offer where offer_id =:id")
//	List<Game> findGamesFromOffer(@Param("id") int id);
		
}
