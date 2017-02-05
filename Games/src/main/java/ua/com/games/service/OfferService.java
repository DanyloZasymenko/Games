package ua.com.games.service;

import java.util.List;

import ua.com.games.entity.Offer;

public interface OfferService {

	void save(Offer offer) throws Exception;
	List<Offer> findAll();
	Offer findOne(int id);
	void delete(int id);
	
	void addGamesToOffer(Offer offer, String [] gameIds) throws Exception;
	
//	List<Game> findGamesFromOffer(int id);
}
