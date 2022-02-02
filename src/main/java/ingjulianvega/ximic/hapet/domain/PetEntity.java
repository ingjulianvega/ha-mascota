package ingjulianvega.ximic.hapet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Pet")
@Entity
public class PetEntity extends BaseEntity{

    @Column
    private String name;
    @Column
    private String type;
}
