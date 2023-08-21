package rhein.personalproject.springboot3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.repository.CarRepository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    // TODO: Create the ResourceNotFoundException
    public Car findById(UUID id) {
        return carRepository
                .findById(id)
                .orElseThrow();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    // TODO: Create the logical Delete
    public void delete(Car car) {
        carRepository.delete(car);
    }

    public void update(Car car) {
        carRepository.save(car);
    }

}
