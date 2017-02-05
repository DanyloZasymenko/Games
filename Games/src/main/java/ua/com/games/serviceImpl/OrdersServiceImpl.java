package ua.com.games.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.games.dao.OrdersDao;
import ua.com.games.entity.Orders;
import ua.com.games.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public void save(Orders order) {
		ordersDao.save(order);
	}

	@Override
	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	@Override
	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		ordersDao.delete(id);
	}

}
