package equinton.dev.kata_energy.domain.port;

import equinton.dev.kata_energy.domain.model.Offer;

public interface CreateOfferOutPort {

    Offer saveOffer(Offer offer);
}
