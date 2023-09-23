package equinton.dev.kata_energy.api.mapper;

import equinton.dev.kata_energy.api.dto.MarketDto;
import equinton.dev.kata_energy.api.dto.OfferDto;
import equinton.dev.kata_energy.api.dto.TimeBlockDto;
import equinton.dev.kata_energy.domain.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

    OfferDto toDto(Offer offer);

    Offer toModel(OfferDto offerDto);


    MarketDto toMarkDto(Market market);

    Market toMarket(MarketDto marketDto);

    @Mapping(target="energyQuantity", source = "energyQuantity.value")
    @Mapping(target="priceLimit", source = "priceLimit.value")
    TimeBlockDto toTimeBlockDto(TimeBlock timeBlock);


    default TimeBlock toTimeBlock(TimeBlockDto timeBlockDto) {
        return new TimeBlock(timeBlockDto.getEnergyQuantity(), timeBlockDto.getPriceLimit());
    }



}
