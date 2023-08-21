package rhein.personalproject.springboot3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rhein.personalproject.springboot3.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("cars")
@Slf4j
@RequiredArgsConstructor
public class CarController {
    private final List<Car> carList = Arrays.asList(Car.builder()
            .name("Kombi")
            .colour("Azul")
            .model("82")
            .numberOfSeat(9)
            .registerNumber(123456789)
            .build(), Car.builder()
            .name("Fusca")
            .colour("Verde")
            .model("79")
            .numberOfSeat(4)
            .registerNumber(987654321)
            .build());

    @GetMapping
    public ResponseEntity<List<Car>> listAll() {
        return ResponseEntity.ok(carList);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        List<Car> cars =  new ArrayList<>(carList);
        cars.add(car);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Car car) {
        List<Car> cars =  new ArrayList<>(carList);
        cars.remove(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Car car) {
        List<Car> cars =  new ArrayList<>(carList);
        Car carFounded = cars.stream().filter(x -> x.equals(car)).findFirst().orElseThrow();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
