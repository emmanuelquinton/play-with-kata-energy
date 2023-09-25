package equinton.dev.kata_energy.storage.adapter;

import equinton.dev.kata_energy.domain.model.Offer;
import equinton.dev.kata_energy.domain.port.CreateOfferOutPort;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaveOfferOutPortAdpater implements CreateOfferOutPort {


    private final List<Offer> offers;

    public SaveOfferOutPortAdpater() {
        offers = new ArrayList<>();
    }

    @Override
    public Offer saveOffer(Offer offer) {
    Offer offerToSave = Offer.builder()
            .market(offer.getMarket())
            .id(UUID.randomUUID())
            .timeBlocks(offer.getTimeBlocks())
            .build();
        offers.add(offerToSave);
        return offerToSave;
    }
}
