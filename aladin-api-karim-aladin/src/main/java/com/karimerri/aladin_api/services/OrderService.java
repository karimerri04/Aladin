package com.karimerri.aladin_api.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.Order;
import com.karimerri.aladin_api.entities.OrderStatus;
import com.karimerri.aladin_api.repositories.OrderRepository;

@Service
@Transactional
public class OrderService {
	private static final AlaDinLogger logger = AlaDinLogger.getLogger(OrderService.class);

	@Autowired
	OrderRepository orderRepository;

	public Order createOrder(Order order) {
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setStatus(OrderStatus.NEW);

		final Order savedOrder = orderRepository.save(order);
		logger.info("New order created. Order Number : {}", savedOrder.getOrderNumber());
		return savedOrder;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrder(String orderNumber) {
		return orderRepository.findByOrderNumber(orderNumber);
	}

	public List<Order> getOrderByCustomer(int id) {
		return orderRepository.findByCustomerOrders(id);
	}

	/*
	 * public List<Order> getOrdersByStatus(String status) { return
	 * orderRepository.getOrdersByStatus(status); }
	 */

	public Order updateOrder(Order order) {
		final Order o = orderRepository.findByOrderNumber(order.getOrderNumber());
		o.setStatus(order.getStatus());
		final Order savedOrder = orderRepository.save(o);
		return savedOrder;
	}

}
