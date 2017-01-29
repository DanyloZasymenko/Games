package ua.com.games.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.games.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
