package web.service;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService{
    public List<Car> returnCar(List<Car> carsList, int count) {
        return carsList.stream().limit(count).collect(Collectors.toList());
    }
}
