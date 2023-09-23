package equinton.dev.kata_energy.domain.service;

import static org.mockito.Mockito.times;

import equinton.dev.kata_energy.domain.model.Market;
import equinton.dev.kata_energy.domain.model.Offer;
import equinton.dev.kata_energy.domain.model.TimeBlock;
import equinton.dev.kata_energy.domain.port.CreateOfferOutPort;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

class CreateOfferServiceTest {

  private static CreateOfferService createOfferService;

  private static CreateOfferOutPort createOfferOutPort;

  @BeforeAll
  public static void beforeAll() {
    createOfferOutPort = Mockito.mock(CreateOfferOutPort.class);
    createOfferService = new CreateOfferService(createOfferOutPort);
  }

  @Test
  void should_create_offer() {
    // given

    Offer offerToCreate = Offer.builder().market(Market.FAST_RESERVE).timeBlock(new TimeBlock(2500, 150)).build();
    Offer createdOffer =
        Offer.builder()
            .id(UUID.randomUUID())
            .market(Market.FAST_RESERVE)
            .timeBlock(new TimeBlock(2500, 150))
            .build();

    BDDMockito.given(createOfferOutPort.saveOffer(offerToCreate)).willReturn(createdOffer);
    // when
    var actualOffer = createOfferService.create(offerToCreate);

      // then
      Assertions.assertThat(actualOffer)
             .as("Check that the offer has been created")
              .isNotNull()
              .isEqualTo(createdOffer);

      BDDMockito.then(createOfferOutPort).should(times(1)).saveOffer(offerToCreate);

  }
}
