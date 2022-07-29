package geektime.spring.springbucks.service;

import java.util.ArrayList;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.model.OrderState;
import geektime.spring.springbucks.repository.CoffeeOrderRepository;


@Service
@Transactional
public class CoffeeOrderService {
	
	private final Logger logger = LoggerFactory.getLogger(CoffeeOrderService.class);
	
    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOrder(String customer, Coffee...coffee) {
    	
    	CoffeeOrder coffeeOrder = new CoffeeOrder();
    	coffeeOrder.setCustomer(customer);
    	coffeeOrder.setItems(new ArrayList<>(Arrays.asList(coffee)));
    	coffeeOrder.setState(OrderState.INIT);
    	
        CoffeeOrder saved = orderRepository.save(coffeeOrder);
        logger.info("New Order: {}", saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
        	logger.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        logger.info("Updated Order: {}", order);
        return true;
    }
}
