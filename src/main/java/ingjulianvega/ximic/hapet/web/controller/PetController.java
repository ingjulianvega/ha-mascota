package ingjulianvega.ximic.hapet.web.controller;


import ingjulianvega.ximic.hapet.services.PetService;
import ingjulianvega.ximic.hapet.web.model.Pet;
import ingjulianvega.ximic.hapet.web.model.PetDto;
import ingjulianvega.ximic.hapet.web.model.PetList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PetController implements PetI {
    private final PetService petService;

    @Override
    public ResponseEntity<PetList> get() {
        return new ResponseEntity<>(petService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(petService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Pet pet) {
        petService.create(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Pet pet) {
        petService.updateById(id, pet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        petService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}