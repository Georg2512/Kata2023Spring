package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(defaultValue="5") Integer count, ModelMap model) {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Volga",1990,"v900ks"));
        carsList.add(new Car("Niva",2023,"v932ps"));
        carsList.add(new Car("Mazda",1000,"vl600s"));
        carsList.add(new Car("Lada",2023,"g000v"));
        carsList.add(new Car("Belaz",2020,"JU753C"));

        CarServiceImpl carsServiceImpl = new CarServiceImpl();
        model.addAttribute("cars", carsServiceImpl.returnCar(carsList,count));

        return "cars";
    }
}
