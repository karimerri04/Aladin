package com.karimerri.aladin_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimerri.aladin_api.entities.Item;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.OrderItemService;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class OrderItemController extends AlaDinAdminBaseController {

	@Autowired
	protected OrderItemService orderItemService;

	@PostMapping(path = "/orderItems/new", consumes = "application/json")
	public OperationResponse createOrder(@RequestBody Item orderItem) {

		final OperationResponse resp = new OperationResponse();

		final Item persistedOrderItem = orderItemService.createOrderItem(orderItem);
		if (persistedOrderItem == null) {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add OrderItem - OrderItem allready exist ");
		} else {

			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Created new product with id : {} and name : {}" + persistedOrderItem.getId()
					+ persistedOrderItem.getItemName() + "info OrderItem created successfully");
		}

		return resp;
	}

	@GetMapping(path = "/orderItems/product/{id}")
	public Item getOrderItemByProductId(@PathVariable Integer id) {

		System.out.println(orderItemService.getOrderItemByProductId(id).getItemName());
		return orderItemService.getOrderItemByProductId(id);
	}

	@GetMapping(path = "/orderItems")
	public List<Item> listOrderItems() {
		return orderItemService.getAllOrderItems();
	}
}
