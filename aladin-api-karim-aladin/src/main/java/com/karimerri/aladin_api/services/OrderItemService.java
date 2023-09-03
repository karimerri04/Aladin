package com.karimerri.aladin_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.commons.AlaDinLogger;
import com.karimerri.aladin_api.entities.Item;
import com.karimerri.aladin_api.repositories.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	private static final AlaDinLogger logger = AlaDinLogger.getLogger(OrderItemService.class);

	@Autowired
	OrderItemRepository orderItemRepository;

	public Item createOrderItem(Item orderItem) {

		final Item savedOrderItem = orderItemRepository.save(orderItem);
		logger.info("New OrderItem created. OrderItem Number : {}", savedOrderItem.getItemName());
		return savedOrderItem;
	}

	public List<Item> getAllOrderItems() {
		return orderItemRepository.findAll();
	}

	public Item getOrderItemByProductId(Integer id) {
		return orderItemRepository.findOrderItemByProductId(id);
	}

	public void truncateOrderItemsTable() {

		orderItemRepository.truncateOrderItemsTable();
	}
}
