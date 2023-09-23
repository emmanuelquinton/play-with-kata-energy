package equinton.dev.kata_energy.domain.model;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

/**
 * Offer placed on the market and containing one or more time blocks
 */
@Getter
@Builder
@AllArgsConstructor
public class Offer {


  private final  UUID id ;
  private final Market market;
  @Valid
  @Singular
  private List<@Valid TimeBlock> timeBlocks;


}

