package com.karimerri.aladin_api.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karimerri.aladin_api.commons.EmailService;
import com.karimerri.aladin_api.entities.Order;
import com.karimerri.aladin_api.models.OperationResponse;
import com.karimerri.aladin_api.models.OperationResponse.ResponseStatusEnum;
import com.karimerri.aladin_api.services.OrderService;
import com.karimerri.aladin_api.utils.AlaDinException;

@CrossOrigin(origins = { "http://10.0.2.2" })
@RestController
public class OrderController extends AlaDinAdminBaseController {
	@Autowired
	protected OrderService orderService;

	@Autowired
	protected EmailService emailService;

	@PostMapping(path = "/orders/new", consumes = "application/json")
	public OperationResponse createOrder(@RequestBody Order order) throws MessagingException {

		System.out.println(order.toString());

		final OperationResponse resp = new OperationResponse();
		final Order persistedOrder = orderService.createOrder(order);
		sendOrderEmail(persistedOrder);
		if (persistedOrder == null) {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add Order - Order allready exist ");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Created new Order with id : {} and name : {}" + persistedOrder.getId()
					+ persistedOrder.getOrderRange() + "info Order created successfully");
		}

		return resp;
	}

	@GetMapping(path = "/orders/customer/{id}")
	public List<Order> getOrderbyCustomer(@PathVariable int id) {

		return orderService.getOrderByCustomer(id);
	}

	@GetMapping(path = "/orders/{orderNumber}")
	public Order getOrderbyNumber(@PathVariable String orderNumber) {

		return orderService.getOrder(orderNumber);
	}

	@GetMapping(path = "/orders")
	public List<Order> listOrders() {

		return orderService.getAllOrders();
	}

	protected void sendOrderEmail(Order order) throws MessagingException {
		try {
			emailService.sendEmail(order.getCustomer().getId().toString(), "new Order", order.toString());
		} catch (final AlaDinException e) {
			logger.error(e);
		}
	}

	@RequestMapping(value = "/orders/{orderNumber}", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute("order") Order order, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		final Order persistedOrder = orderService.updateOrder(order);

		logger.debug("Updated order with orderNumber : {}", persistedOrder.getAddresses());
		redirectAttributes.addFlashAttribute("info", "Order updated successfully");
		return "redirect:/orders";
	}
}
