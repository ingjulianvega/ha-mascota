package ingjulianvega.ximic.hapet.services;



import ingjulianvega.ximic.hapet.web.model.PagedPetList;
import ingjulianvega.ximic.hapet.web.model.Pet;
import ingjulianvega.ximic.hapet.web.model.PetDto;
import ingjulianvega.ximic.hapet.web.model.PetList;

import java.util.UUID;

public interface PetService {
    PagedPetList get(Boolean usingCache, Integer pageNo, Integer pageSize, String sortBy);

    PetDto getById(UUID id);

    void create(Pet pet);

    void updateById(UUID id, Pet pet);

    void deleteById(UUID id);
}
