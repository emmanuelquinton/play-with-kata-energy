package equinton.dev.kata_energy.domain.service;

import equinton.dev.kata_energy.domain.model.Offer;

public sealed interface CreateOfferUserCase permits  CreateOfferService {


    Offer create(Offer offer);


}
