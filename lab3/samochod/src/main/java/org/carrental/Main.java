package org.carrental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.carrental.model.Car;
import org.carrental.model.CarClass;
import org.carrental.model.CarStatus;
import org.carrental.repository.CarRepository;
import org.carrental.service.CarService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);

        Car car = new Car(null, "volkswagen", "golf", "123", CarClass.STANDARD, CarStatus.AVAILABLE);

        Car car2 = new Car(null, "volkswagen", "golf", "abc", CarClass.STANDARD, CarStatus.RENTED);

        Car car3 = new Car(null, "volkswagen", "golf", "xyz", CarClass.STANDARD, CarStatus.AVAILABLE);

        Car createdCar = carService.createCar(car);

        carService.createCar(car2);

        carService.createCar(car3);

        logger.info(createdCar);

        carService.updateModel(2, "polo");

        Car carById = carService.getById(0);

        logger.info(carById);

        List<Car> availableCar = carService.getAvailableCars();

        logger.info(availableCar);

        carService.removeById(1);

        List<Car> allCar = carService.getAll();

        logger.info(allCar);

        carService.removeallCar();







//        Car invalidCar = new Car(null, "volkswagen", "golf", "1234", CarClass.STANDARD, CarStatus.AVAILABLE);
//
//        carService.createCar(invalidCar);


    }
}