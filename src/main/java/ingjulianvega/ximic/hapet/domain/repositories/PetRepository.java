package ingjulianvega.ximic.hapet.domain.repositories;

import ingjulianvega.ximic.hapet.domain.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID>, JpaSpecificationExecutor<PetEntity> {
    List<PetEntity> findAllByOrderByName();
}
