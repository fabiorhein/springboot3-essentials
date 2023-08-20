package rhein.personalproject.springboot3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rhein.personalproject.springboot3.domain.Car;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("cars")
@Slf4j
@RequiredArgsConstructor
public class CarController {
    @GetMapping
    public List<Car> listAll() {

        Car car1 = Car.builder()
                .name("Fusca")
                .colour("Verde")
                .model("79")
                .numberOfSeat(4)
                .registerNumber(123456789)
                .build();

        Car car2 = Car.builder()
                .name("Fusca")
                .colour("Verde")
                .model("79")
                .numberOfSeat(4)
                .registerNumber(123456789)
                .build();
        List<Car> carList = Arrays.asList(car1, car2);
        log.info(carList.toString());
        return carList;
    }
}
