package rhein.personalproject.springboot3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.exception.BadRequestException;
import rhein.personalproject.springboot3.exception.ResourceNotFoundException;
import rhein.personalproject.springboot3.repository.CarRepository;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;
import rhein.personalproject.springboot3.util.CarCreator;
import rhein.personalproject.springboot3.util.CarPostRequestBodyCreator;
import rhein.personalproject.springboot3.util.CarPutRequestBodyCreator;
import rhein.personalproject.springboot3.util.Utils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DisplayName("Car Service Tests")
class CarServiceTest {
    @InjectMocks
    private CarService carService;
    @Mock
    private CarRepository carRepositoryMock;
    @Mock
    private Utils utilsMock;
    @BeforeEach
    private void setUp() {
        List<Car> cars = List.of(CarCreator.createValidCar());
        BDDMockito.when(carRepositoryMock.findAll())
                .thenReturn(cars);

        BDDMockito.when(carRepositoryMock.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.of(CarCreator.createValidCar()));

        BDDMockito.when(carRepositoryMock.save(ArgumentMatchers.any(Car.class)))
                .thenReturn(CarCreator.createValidCar());

        BDDMockito.doNothing().when(carRepositoryMock).delete(ArgumentMatchers.any(Car.class));

        BDDMockito.when(carRepositoryMock.save(CarCreator.createValidCar()))
                .thenReturn(CarCreator.createValidUpdatedCar());

        BDDMockito.when(
                        utilsMock.findCarOrThrowNotFound(ArgumentMatchers.any(UUID.class), ArgumentMatchers.any(CarRepository.class)))
                .thenReturn(CarCreator.createValidCar());
    }

    @Test
    @DisplayName("listAll return a list of cars when successful")
    public void listAll_ReturnListOfCars_WhenSuccessfull() {
        String expectedName = CarCreator.createValidCar().getName();
        List<Car> cars = carService.listAll();
        Assertions.assertThat(cars).isNotNull();
        Assertions.assertThat(cars).isNotEmpty();
        Assertions.assertThat(cars.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findById returns a car when successful")
    public void findById_ReturnListOfCars_WhenSuccessfull() {
        UUID expectedId = CarCreator.createValidCar().getId();
        UUID id = UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f");
        Car car = carService.findByIdOrThrowBadRequestException(id);
        Assertions.assertThat(car).isNotNull();
        Assertions.assertThat(car.getId()).isNotNull();
        Assertions.assertThat(car.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException throws BadRequestException when car is not found")
    void findByIdOrThrowBadRequestException_ThrowsBadRequestException_WhenCarIsNotFound(){
        UUID id = UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f");
        BDDMockito.when(carRepositoryMock.findById(ArgumentMatchers.any(UUID.class)))
                .thenReturn(Optional.empty());
        Assertions.assertThatExceptionOfType(BadRequestException.class)
                .isThrownBy(() -> carService.findByIdOrThrowBadRequestException(id));
    }

    @Test
    @DisplayName("save creates a car when successful")
    public void save_CreatesCar_WhenSuccessfull() {
        UUID expectedId = CarCreator.createValidCar().getId();
        CarPostRequestBody carToBeSaved = CarPostRequestBodyCreator.createCarPostRequestBody();
        Car savedCar = carService.save(carToBeSaved);

        Assertions.assertThat(savedCar).isNotNull();
        Assertions.assertThat(savedCar.getId())
                .isNotNull()
                .isEqualTo(expectedId);
    }

    @Test
    @DisplayName("delete removes the car when successful")
    public void delete_RemovesCar_WhenSuccessfull() {
        UUID id = UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f");
        Assertions.assertThatCode(() -> carService.delete(id))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("update save updated car when successful")
    public void update_SaveUpdatedCar_WhenSuccessfull() {
        CarPutRequestBody validUpdatedCar = CarPutRequestBodyCreator.createCarPutRequestBody();
        Assertions.assertThatCode(() -> carService.update(validUpdatedCar))
                .doesNotThrowAnyException();
    }
}