package rhein.personalproject.springboot3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.service.CarService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cars")
@Slf4j
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> listAll() {
        return ResponseEntity.ok(carService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Car car) {
        carService.update(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
