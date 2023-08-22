package rhein.personalproject.springboot3.util;

import org.springframework.stereotype.Component;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.exception.ResourceNotFoundException;
import rhein.personalproject.springboot3.repository.CarRepository;

import java.util.UUID;

@Component
public class Utils {
    public Car findCarOrThrowNotFound(UUID id, CarRepository carRepository) {
        return carRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anime Not Found"));
    }
}
