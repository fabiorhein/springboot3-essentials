package rhein.personalproject.springboot3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class CarMapper {
    public static final CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    public abstract Car toCar(CarPostRequestBody carPostRequestBody);
    public abstract Car toCar(CarPutRequestBody carPutRequestBody);
}
