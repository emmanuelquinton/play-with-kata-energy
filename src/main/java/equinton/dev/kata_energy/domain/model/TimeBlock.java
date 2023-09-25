package equinton.dev.kata_energy.domain.model;

import jakarta.validation.constraints.*;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The time block shows the amount of energy (in MW) that will be produced and a floor price below which we will not sell.
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class TimeBlock {

  private UUID id;

  private EnergyQuantity energyQuantity;

  private PriceLimit priceLimit;


  /**
   * Constructor with only required parameters
   */
  public TimeBlock(Integer energyQuantity, Integer priceLimit) {
    this.id = UUID.randomUUID();
    this.energyQuantity = new EnergyQuantity(energyQuantity);
    this.priceLimit = new PriceLimit(priceLimit);

  }
}

