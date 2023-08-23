package rhein.personalproject.springboot3.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;
import rhein.personalproject.springboot3.service.CarService;
import rhein.personalproject.springboot3.util.CarCreator;
import rhein.personalproject.springboot3.util.CarPostRequestBodyCreator;
import rhein.personalproject.springboot3.util.CarPutRequestBodyCreator;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DisplayName("Car Controller Tests")
class CarControllerTest {
    @InjectMocks
    private CarController carController;
    @Mock
    private CarService carServiceMock;

    @BeforeEach
    public void setUp() {
        List<Car> cars = List.of(CarCreator.createValidCar());
        BDDMockito.when(carServiceMock.listAll())
                        .thenReturn(cars);

        BDDMockito.when(carServiceMock.findByIdOrThrowBadRequestException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(CarCreator.createValidCar());

        BDDMockito.when(carServiceMock.save(ArgumentMatchers.any(CarPostRequestBody.class)))
                .thenReturn(CarCreator.createValidCar());

        BDDMockito.doNothing().when(carServiceMock).update(ArgumentMatchers.any(CarPutRequestBody.class));

        BDDMockito.doNothing().when(carServiceMock).delete(ArgumentMatchers.any(UUID.class));
    }

    @Test
    @DisplayName("listAll return a list of cars when successful")
    public void listAll_ReturnListOfCars_WhenSuccessfull() {
        String expectedName = CarCreator.createValidCar().getName();
        List<Car> cars = carController.listAll().getBody();
        Assertions.assertThat(cars).isNotNull();
        Assertions.assertThat(cars)
                .isNotEmpty()
                .hasSize(1);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById returns a car when successful")
    public void findById_ReturnListOfCars_WhenSuccessfull() {
        UUID expectedId = CarCreator.createValidCar().getId();
        UUID id = UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f");
        Car car = carController.findById(id).getBody();
        Assertions.assertThat(car).isNotNull();
        Assertions.assertThat(car.getId())
                .isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("save creates a car when successful")
    public void save_CreatesCar_WhenSuccessfull() {
        UUID expectedId = CarCreator.createValidCar().getId();
        CarPostRequestBody carToBeSaved = CarPostRequestBodyCreator.createCarPostRequestBody();
        Car savedCar = carController.save(carToBeSaved).getBody();
        Assertions.assertThat(savedCar).isNotNull().isEqualTo(CarCreator.createValidCar());
        Assertions.assertThat(savedCar.getId())
                .isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("delete removes the car when successful")
    public void delete_RemovesCar_WhenSuccessfull() {
        UUID id = CarCreator.createValidCar().getId();
        ResponseEntity<Void> responseEntity = carController.delete(id);
        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(responseEntity.getBody()).isNull();
    }

    @Test
    @DisplayName("update save updated car when successful")
    public void update_SaveUpdatedCar_WhenSuccessfull() {
        CarPutRequestBody carToBeUpdated = CarPutRequestBodyCreator.createCarPutRequestBody();
        ResponseEntity<Void> responseEntity = carController.update(carToBeUpdated);
        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(responseEntity.getBody()).isNull();
    }

}