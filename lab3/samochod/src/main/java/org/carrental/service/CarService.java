package org.carrental.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.ValidationException;
import org.carrental.model.Car;
import org.carrental.model.CarStatus;
import org.carrental.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car createCar(Car car) {
        if (car.getMake() == null || car.getMake().isBlank()){
            throw new ValidationException("cannot be blank", "make");
        }

        if (car.getVin().length() != 3){
            throw new ValidationException("max length is 3", "vin");
        }

        carRepository.create(car);

        return car;
    }

    public Car getById(Integer id) {
        Optional<Car> car = carRepository.getById(id);

        return car.orElseThrow(() -> new CarNotFoundException("Car does not exist"));
    }
    public List<Car> getAvailableCars(){
        return carRepository.getByStatus(CarStatus.AVAILABLE);
    }

    public Car updateModel(Integer id, String newModel){
        if (newModel.isBlank()){
            throw new ValidationException("cannot be blank", "newModel");
        }

       return carRepository.updateModel(id, newModel).orElseThrow(() -> new CarNotFoundException("car does not exist"));
    }

    public void removeById(Integer id){
        carRepository.removeById(id);
    }

    public void removeallCar() {
        carRepository.removeAll();
    }

    public List<Car> getAll(){
       return carRepository.getAll();
    }


}
