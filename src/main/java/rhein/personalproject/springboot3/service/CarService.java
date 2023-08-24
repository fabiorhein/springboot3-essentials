package rhein.personalproject.springboot3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.exception.BadRequestException;
import rhein.personalproject.springboot3.mapper.CarMapper;
import rhein.personalproject.springboot3.repository.CarRepository;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public Car findByIdOrThrowBadRequestException(UUID id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Car not found"));
    }

    @Transactional
    public Car save(CarPostRequestBody carPostRequestBody) {
        return carRepository.save(CarMapper.INSTANCE.toCar(carPostRequestBody));
    }

    // TODO: Create the logical Delete
    public void delete(UUID id) {
        carRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void update(CarPutRequestBody carPutRequestBody) {
        Car savedCar = findByIdOrThrowBadRequestException(carPutRequestBody.getId());
        Car car = CarMapper.INSTANCE.toCar(carPutRequestBody);
        car.setId(savedCar.getId());
        carRepository.save(car);
    }

}
