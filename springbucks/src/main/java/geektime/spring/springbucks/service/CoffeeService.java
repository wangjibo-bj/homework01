package geektime.spring.springbucks.service;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.repository.CoffeeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {
	
	
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Optional<Coffee> findOneCoffee(String name) {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("name", exact().ignoreCase());
//        Optional<Coffee> coffee = coffeeRepository.findOne(
//                Example.of(Coffee.builder().name(name).build(), matcher));
//        log.info("Coffee Found: {}", coffee);
        return null;
    }
}
