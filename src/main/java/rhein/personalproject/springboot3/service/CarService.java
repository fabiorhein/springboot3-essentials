package rhein.personalproject.springboot3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.repository.CarRepository;
import rhein.personalproject.springboot3.util.Utils;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final Utils utils;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public Car findById(UUID id) {
        return utils.findCarOrThrowNotFound(id, carRepository);
    }

    @Transactional
    public Car save(Car car) {
        return carRepository.save(car);
    }

    // TODO: Create the logical Delete
    public void delete(UUID id) {
        carRepository.delete(findById(id));
    }

    @Transactional
    public Car update(Car car) {
        return carRepository.save(car);
    }

}
