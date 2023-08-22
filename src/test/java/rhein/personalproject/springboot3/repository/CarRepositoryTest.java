package rhein.personalproject.springboot3.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.util.CarCreator;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Car Repository Tests")
class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    @DisplayName("Save creates car when successful")
    public void save_PersistAnime_WhenSuccessful() {
        Car car = CarCreator.createValidCar();
        Car savedCar = this.carRepository.save(car);
        Assertions.assertThat(savedCar.getId()).isNotNull();
        Assertions.assertThat(savedCar.getName()).isNotNull();
        Assertions.assertThat(savedCar.getName()).isEqualTo(car.getName());
    }

    @Test
    @DisplayName("Save updates car when successful")
    public void save_UpdateAnime_WhenSuccessful() {
        Car car = CarCreator.createValidCar();
        Car savedCar = this.carRepository.save(car);
        savedCar.setName("That is a refactor car!");
        Car updatedCar = this.carRepository.save(savedCar);
        Assertions.assertThat(savedCar.getId()).isNotNull();
        Assertions.assertThat(savedCar.getName()).isNotNull();
        Assertions.assertThat(savedCar.getName()).isEqualTo(updatedCar.getName());
    }


    @Test
    @DisplayName("listAll return a list of cars when successful")
    public void listAll_ReturnListOfCars_WhenListIsEmpty() {
        List<Car> cars = carRepository.findAll();
        Assertions.assertThat(cars).isNotNull();
        Assertions.assertThat(cars).isEmpty();
    }

    @Test
    @DisplayName("Delete removes anime when successful")
    public void delete_RemoveAnime_WhenSuccessful() {
        Car car = CarCreator.createCarToBeSaved();
        Car savedCar = this.carRepository.save(car);
        this.carRepository.delete(car);
        Optional<Car> carOptional = this.carRepository.findById(savedCar.getId());
        Assertions.assertThat(carOptional.isEmpty()).isTrue();
    }
}