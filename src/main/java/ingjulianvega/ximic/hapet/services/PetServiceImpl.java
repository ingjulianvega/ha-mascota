package ingjulianvega.ximic.hapet.services;


import ingjulianvega.ximic.hapet.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.hapet.domain.PetEntity;
import ingjulianvega.ximic.hapet.domain.repositories.PetRepository;
import ingjulianvega.ximic.hapet.exception.PetException;
import ingjulianvega.ximic.hapet.web.Mappers.PetMapper;
import ingjulianvega.ximic.hapet.web.model.Pet;
import ingjulianvega.ximic.hapet.web.model.PetDto;
import ingjulianvega.ximic.hapet.web.model.PetList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;


    @Cacheable(cacheNames = "personListCache")
    @Override
    public PetList get() {
        log.debug("get()...");
        return PetList
                .builder()
                .personList(petMapper.personEntityListToPersonDtoList(petRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "personCache")
    @Override
    public PetDto getById(UUID id) {
        log.debug("getById()...");
        return petMapper.personEntityToPersonDto(
                petRepository.findById(id).orElseThrow(() -> PetException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.PET_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.PET_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.PET_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.PET_NOT_FOUND_SOLUTION)
                        .build()));
    }

    @Override
    public void create(Pet pet) {
        log.debug("create()...");
        petMapper.personEntityToPersonDto(
                petRepository.save(
                        petMapper.personDtoToPersonEntity(
                                PetDto
                                        .builder()
                                        .name(pet.getName())
                                        .type(pet.getType()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Pet pet) {
        log.debug("updateById...");
        PetEntity petEntity = petRepository.findById(id).orElseThrow(() -> PetException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.PET_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.PET_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.PET_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.PET_NOT_FOUND_SOLUTION)
                .build());
        petEntity.setName(pet.getName());
        petEntity.setType(pet.getType());

        petRepository.save(petEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        petRepository.deleteById(id);
    }
}