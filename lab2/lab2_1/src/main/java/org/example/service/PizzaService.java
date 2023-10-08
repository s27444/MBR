package org.example.service;

import org.example.exception.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {

    private List<Order> orderList = new ArrayList<>();

    private List<Pizza> pizzaList;

    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzas) {
        // Sprawdzamy czy zamówione pizze są dostępne
//        boolean allPizzasAvailable = orderedPizzas.stream().allMatch(Pizza::isAvailable);
//
//        if (!allPizzasAvailable) {
//            // Jeśli któreś z zamówionych dań nie są dostępne, zwracamy null
//            return null;
//        }

        //        // Obliczamy cenę zamówienia
//        double orderPrice = orderedPizzas.stream().mapToDouble(Pizza::getPrice).sum();
//
//        // Tworzymy obiekt Order
//        int orderNumber = orderList.size() + 1; // Numer zamówienia to kolejny dostępny numer
//        Order order = new Order(orderNumber, orderedPizzas, orderPrice);
//
//        // Dodajemy order do OrderList
//        orderList.add(order);
//
//        // Zwracamy zamówienie
//        return order;

        if(getAvailablePizzas().containsAll(orderedPizzas))
        {
            double sum = orderedPizzas.stream()
                    .map(Pizza::getPrice)
                    .reduce(0D, (current, price) -> current + price);
            Order order = new Order(orderList.size(), orderedPizzas, sum);
            orderList.add(order);

            return order;
        }else {
            throw new PizzaNotFoundException();
        }

    }

    public List<Pizza> getAvailablePizzas() {
        // Filtrujemy dostępne pizze i zwracamy je w postaci listy
        return pizzaList.stream()
                .filter(Pizza::isAvailable)
                .collect(Collectors.toList());
    }


}
