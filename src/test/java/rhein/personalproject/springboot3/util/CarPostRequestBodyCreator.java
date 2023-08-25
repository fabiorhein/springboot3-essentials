package rhein.personalproject.springboot3.util;

import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;

public class CarPostRequestBodyCreator {
    public static CarPostRequestBody createCarPostRequestBody() {
        return CarPostRequestBody.builder()
                .name(CarCreator.createCarToBeSaved().getName())
                .colour(CarCreator.createCarToBeSaved().getColour())
                .model(CarCreator.createCarToBeSaved().getModel())
                .numberOfSeat(CarCreator.createCarToBeSaved().getNumberOfSeat())
                .registerNumber(CarCreator.createCarToBeSaved().getRegisterNumber())
                .build();
    }
}
