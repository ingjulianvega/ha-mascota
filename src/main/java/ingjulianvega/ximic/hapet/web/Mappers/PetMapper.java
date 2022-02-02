package ingjulianvega.ximic.hapet.web.Mappers;


import ingjulianvega.ximic.hapet.domain.PetEntity;
import ingjulianvega.ximic.hapet.web.model.PetDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface PetMapper {
    PetDto personEntityToPersonDto(PetEntity petEntity);

    PetEntity personDtoToPersonEntity(PetDto petDto);

    ArrayList<PetDto> personEntityListToPersonDtoList(List<PetEntity> petEntityList);
}

