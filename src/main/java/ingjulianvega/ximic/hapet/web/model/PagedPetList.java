package ingjulianvega.ximic.hapet.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedPetList implements Serializable {
    static final long serialVersionUID = -2956822045667820977L;

    private long totalItems;
    private Page page;
    private ArrayList<PetDto> petList;
}
