package ingjulianvega.ximic.hapet.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

  @NotBlank
  private String name = null;
  @NotBlank
  private String type = null;

}

