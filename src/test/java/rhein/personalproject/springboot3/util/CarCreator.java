package rhein.personalproject.springboot3.util;

import rhein.personalproject.springboot3.domain.Car;

import java.util.UUID;

public class CarCreator {
    public static Car createCarToBeSaved() {
        return Car.builder()
                .name("Kombi")
                .colour("Azul")
                .model("82")
                .numberOfSeat(9)
                .registerNumber(123456789)
                .build();
    }

    public static Car createValidCar() {
        Car carCreated = Car.builder()
                .name("Kombi")
                .colour("Azul")
                .model("82")
                .numberOfSeat(9)
                .registerNumber(123456789)
                .build();
        carCreated.setId(UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f"));
        return carCreated;
    }

    public static Car createValidUpdatedCar() {
        Car carCreated = Car.builder()
                .name("Kombi")
                .colour("Branca")
                .model("82")
                .numberOfSeat(9)
                .registerNumber(123456789)
                .build();
        carCreated.setId(UUID.fromString("ad19f068-c91c-4603-8a09-84f1f72cb50f"));
        return carCreated;
    }
}
