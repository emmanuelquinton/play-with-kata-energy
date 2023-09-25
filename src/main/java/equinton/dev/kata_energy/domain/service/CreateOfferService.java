package equinton.dev.kata_energy.domain.service;

import equinton.dev.kata_energy.domain.model.Offer;
import equinton.dev.kata_energy.domain.port.CreateOfferOutPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateOfferService implements CreateOfferUserCase{


    private final CreateOfferOutPort createOfferOutPort;

    @Override
    public Offer create(Offer offer) {
        return createOfferOutPort.saveOffer(offer);
    }
}
