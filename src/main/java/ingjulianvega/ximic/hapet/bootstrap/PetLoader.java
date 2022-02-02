package ingjulianvega.ximic.hapet.bootstrap;



import ingjulianvega.ximic.hapet.domain.PetEntity;
import ingjulianvega.ximic.hapet.domain.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class PetLoader implements CommandLineRunner {

    private final PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {
        if (petRepository.count() == 0) {
            loadMaritalStatusObjects();
        }
    }

    private void loadMaritalStatusObjects() {
        petRepository.saveAll(Arrays.asList(
                PetEntity.builder().name("Coco").type("Perro").build(),
                PetEntity.builder().name("Thor").type("Gato").build(),
                PetEntity.builder().name("Max").type("Perro").build(),
                PetEntity.builder().name("Rocky").type("Gato").build(),
                PetEntity.builder().name("Toby").type("Perro").build(),
                PetEntity.builder().name("Simba").type("Gato").build(),
                PetEntity.builder().name("Leo").type("Perro").build(),
                PetEntity.builder().name("Lucas").type("Gato").build(),
                PetEntity.builder().name("Zeus").type("Perro").build(),
                PetEntity.builder().name("Bruno").type("Gato").build(),
                PetEntity.builder().name("Luna").type("Perro").build(),
                PetEntity.builder().name("Nala").type("Otro").build(),
                PetEntity.builder().name("Kira").type("Perro").build(),
                PetEntity.builder().name("Lola").type("Otro").build(),
                PetEntity.builder().name("Bimba").type("Perro").build(),
                PetEntity.builder().name("Mia").type("Gato").build(),
                PetEntity.builder().name("Noa").type("Perro").build(),
                PetEntity.builder().name("Kiara").type("Otro").build(),
                PetEntity.builder().name("Dana").type("Perro").build()
        ));
    }
}
