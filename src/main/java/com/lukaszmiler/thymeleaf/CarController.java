package com.lukaszmiler.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    List<Car> carList = new ArrayList<>();

    public CarController() {
        carList.add(new Car(1, "Toyota", "Yaris", "White"));
        carList.add(new Car(2, "Audi", "Q8", "Red"));
        carList.add(new Car(3, "Skoda", "Superb", "Blue"));
        carList.add(new Car(4, "Fiat", "Sienna", "Blue"));
    }

    @GetMapping("/car")
    public String showCars(Model model) {
        model.addAttribute("cars", carList);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car car) {
        carList.add(car);
        return "redirect:/car";
    }

    @GetMapping("/removeCar")
    public String removeCar(@ModelAttribute Car car) {
        for (Car c : carList) {
            if (c.getId() == car.getId()) {
                carList.remove(c);
                break;
            }
        }
        return "redirect:/car";
    }

    @GetMapping("/modifyCar")
    public String modifyCar(@ModelAttribute Car car) {
        for (Car c : carList) {
            if (c.getId() == car.getId()) {
                c.setId(car.getId());
                c.setModel(car.getModel());
                c.setMark(car.getMark());
                c.setColor(car.getColor());
                break;
            }
        }
        return "redirect:/car";
    }

}
