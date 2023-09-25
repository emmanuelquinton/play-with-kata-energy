package equinton.dev.kata_energy.api.mapper;

import equinton.dev.kata_energy.api.dto.MarketDto;
import equinton.dev.kata_energy.api.dto.OfferDto;
import equinton.dev.kata_energy.api.dto.TimeBlockDto;
import equinton.dev.kata_energy.domain.model.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

class OfferMapperTest {


    @Test
    void should_map_dto_to_offer() {
        //given
        OfferDto offerDto = new OfferDto(MarketDto.FAST_RESERVE, List.of(new TimeBlockDto(2500, 985)));

        //when
        var actualOffer = OfferMapper.INSTANCE.toModel(offerDto);

        //then
        Assertions.assertThat(actualOffer)
                .as("check that the dto has been mapped")
                .isNotNull()
                .hasFieldOrPropertyWithValue("market", Market.FAST_RESERVE)
                .extracting("timeBlocks")
                .isNotNull()
                ;
        Assertions.assertThat(actualOffer.getTimeBlocks())
                .as("check that the timeBlocks have been mapped")
                .isNotNull()
                .hasSize(1)
                .extracting(TimeBlock::getEnergyQuantity, TimeBlock::getPriceLimit)
                .contains(Tuple.tuple(new EnergyQuantity(2500), new PriceLimit(985)));
    }
    @Test
    void should_map_offer_to_dto() {
    // given
    Offer offer =
        Offer.builder()
            .market(Market.FAST_RESERVE)
            .timeBlocks(List.of(new TimeBlock(2500, 985)))
                .build();

        //when
        var actualOfferDto = OfferMapper.INSTANCE.toDto(offer);

        //then
        Assertions.assertThat(actualOfferDto)
                .as("check that the offer has been mapped")
                .isNotNull()
                .hasFieldOrPropertyWithValue("market", MarketDto.FAST_RESERVE)
                .extracting("timeBlocks")
                .isNotNull()
        ;
        Assertions.assertThat(actualOfferDto.getTimeBlocks())
                .as("check that the timeBlocks have been mapped")
                .isNotNull()
                .hasSize(1)
                .extracting(TimeBlockDto::getEnergyQuantity, TimeBlockDto::getPriceLimit)
                .contains(Tuple.tuple(2500,985));
        ;
    }
}
