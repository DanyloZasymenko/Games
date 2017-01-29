package ua.com.games.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.games.dao.GameDao;
import ua.com.games.dao.OfferDao;
import ua.com.games.entity.Game;
import ua.com.games.entity.Offer;
import ua.com.games.service.OfferService;
import ua.com.games.validator.main.Validator;

@Service
public class OfferSeviceImpl implements OfferService{

	@Autowired
	private OfferDao offerDao;
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	@Qualifier("offerValidator")
	private Validator validator;
	
	@Override
	public void save(Offer offer) throws Exception {
		
		validator.validate(offer);
		
		offerDao.save(offer);
	}

	@Override
	public List<Offer> findAll() {
		return offerDao.findAll();
	}

	@Override
	public Offer findOne(int id) {
		return offerDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		offerDao.delete(id);
	}

	@Override
	@Transactional
	public void addGamesToOffer(Offer offer, String[] gameIds) {
		
		List<Game> games = new ArrayList<>();
		
		for (int i = 0; i < gameIds.length; i++) {
			Game game = gameDao.findOne(Integer.parseInt(gameIds[i]));
			games.add(game);
		}
		offer.setGames(games);
	}

//	@Override
//	public List<Game> findGamesFromOffer(int id) {
//		return offerDao.findGamesFromOffer(id);
//	}

}
