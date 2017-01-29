package ua.com.games.service;

import java.util.List;

import ua.com.games.entity.Game;
import ua.com.games.entity.Orders;

public interface OrdersService {

	void save(Orders order);
	List<Orders> findAll();
	Orders findOne(int id);
	void delete(int id);

	//List<Game> verification(List<Game> oldGames, List<Game> newGames);
	
}
