package rhein.personalproject.springboot3.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import rhein.personalproject.springboot3.domain.Car;

import java.util.List;
@ExtendWith(SpringExtension.class)
class CarControllerTest {

    @InjectMocks
    private CarController carController;

    private final Car car = Car.builder()
            .name("Kombi")
            .colour("Azul")
            .model("82")
            .numberOfSeat(9)
            .registerNumber(123456789)
            .build();

    @Test
    @DisplayName("listAll return a list of cars when successful")
    public void listAll_ReturnListOfCars_WhenSuccessfull() {
        List<Car> cars = carController.listAll().getBody();
        Assertions.assertThat(cars).isNotNull();
        Assertions.assertThat(cars).isNotEmpty();
        Assertions.assertThat(cars.get(0).getName()).isEqualTo(this.car.getName());
    }

    @Test
    @DisplayName("listAll return a list of cars when successful")
    public void save_CreatesCar_WhenSuccessfull() {
        String expectedName = this.car.getName();
        Car savedCar = carController.save(this.car).getBody();

        Assertions.assertThat(savedCar).isNotNull();
        Assertions.assertThat(savedCar.getName())
                .isNotNull()
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("delete removes the car when successful")
    public void delete_RemovesCar_WhenSuccessfull() {
        ResponseEntity<Void> responseEntity = carController.delete(this.car);
        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(responseEntity.getBody()).isNull();
    }

    @Test
    @DisplayName("delete removes the car when successful")
    public void update_SaveUpdatedCar_WhenSuccessfull() {
        ResponseEntity<Void> responseEntity = carController.update(this.car);
        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(responseEntity.getBody()).isNull();
    }

}