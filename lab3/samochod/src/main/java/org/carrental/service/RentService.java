package org.carrental.service;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.RentException;
import org.carrental.model.Car;
import org.carrental.model.rent.Rent;
import org.carrental.repository.RentRepository;
import org.user.service.UserService;

import java.time.LocalDate;

@RequiredArgsConstructor
public class RentService {
    private final CarService carService;
    private final RentRepository rentRepository;
    private final UserService userService;

    public Rent create(Integer carId, Integer userId, LocalDate startDate, int rentLength){
        // Start date nie może być w przeszłości
        // carId != null
        // userId != null
        // rentLength > 0
        Car selectedCar;

        try{
            selectedCar = carService.getById(carId);
        }catch(CarNotFoundException exception){
            throw new RentException("Cannot create rent", exception);
        }
        // To samo dla klienta


        Double price = selectedCar.getDailyRate() * rentLength;

        LocalDate endDate = startDate.plusDays(rentLength);

        Rent rent = new Rent(carId, userId, startDate, endDate, price);

        return rentRepository.create(rent);

    }
}
