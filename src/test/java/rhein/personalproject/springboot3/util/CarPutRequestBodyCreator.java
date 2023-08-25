package rhein.personalproject.springboot3.util;

import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;

public class CarPutRequestBodyCreator {
    public static CarPutRequestBody createCarPutRequestBody() {
        return CarPutRequestBody.builder()
                .id(CarCreator.createValidUpdatedCar().getId())
                .name(CarCreator.createValidUpdatedCar().getName())
                .colour(CarCreator.createValidUpdatedCar().getColour())
                .model(CarCreator.createValidUpdatedCar().getModel())
                .numberOfSeat(CarCreator.createValidUpdatedCar().getNumberOfSeat())
                .registerNumber(CarCreator.createValidUpdatedCar().getRegisterNumber())
                .build();
    }
}
