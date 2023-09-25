package equinton.dev.kata_energy.api.endpoint;

import equinton.dev.kata_energy.api.dto.OfferDto;
import equinton.dev.kata_energy.api.dto.OffersDto;
import equinton.dev.kata_energy.api.mapper.OfferMapper;
import equinton.dev.kata_energy.domain.service.CreateOfferUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OfferController implements OffersApi{
    private final CreateOfferUserCase createOfferService;

    @Override
    public ResponseEntity<OfferDto> createOffer(OfferDto offerDto) {
        var offer = createOfferService.create(OfferMapper.INSTANCE.toModel(offerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(OfferMapper.INSTANCE.toDto(offer));
    }

    @Override
    public ResponseEntity<OffersDto> getOffers() {
        return null;
    }
}
