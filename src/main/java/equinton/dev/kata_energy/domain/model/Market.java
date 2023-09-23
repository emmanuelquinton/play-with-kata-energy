package equinton.dev.kata_energy.domain.model;

import jakarta.annotation.Generated;

/**
 * Gets or Sets Market
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum Market {
  
  PRIMARY_RESERVE("PRIMARY_RESERVE"),
  
  SECONDARY_RESERVE("SECONDARY_RESERVE"),
  
  FAST_RESERVE("FAST_RESERVE");

  private String value;

  Market(String value) {
    this.value = value;
  }

}

