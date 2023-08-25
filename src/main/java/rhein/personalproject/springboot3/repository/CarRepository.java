package rhein.personalproject.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rhein.personalproject.springboot3.domain.Car;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
