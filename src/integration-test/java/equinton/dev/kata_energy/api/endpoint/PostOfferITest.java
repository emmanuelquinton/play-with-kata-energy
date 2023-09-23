package equinton.dev.kata_energy.api.endpoint;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import equinton.dev.kata_energy.api.dto.MarketDto;
import equinton.dev.kata_energy.api.dto.OfferDto;
import equinton.dev.kata_energy.api.dto.TimeBlockDto;
import equinton.dev.kata_energy.application.config.KataEnergyConfiguration;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {OfferController.class})
@Import({KataEnergyConfiguration.class})
class PostOfferITest {

    private static final String POST_OFFER_URL = "/api/v1/offers";
    @Autowired
    private WebApplicationContext webApplicationContext;

    private final ObjectMapper  objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void should_create_create_offer() throws Exception {
        //given
        var  offerToCreate = new OfferDto();
        var timeBlock = new TimeBlockDto().energyQuantity(2500).priceLimit(150);

        offerToCreate.setMarket(MarketDto.PRIMARY_RESERVE);
        offerToCreate.timeBlocks(List.of(timeBlock));
        //when
        mockMvc
                .perform(MockMvcRequestBuilders.post(POST_OFFER_URL)
                        .content(objectMapper.writeValueAsBytes(offerToCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        //then
    }

    @Test
    void should_post_offer_return_status_400_when_body_is_null() throws Exception {
        //given

        //when
        mockMvc
                .perform(MockMvcRequestBuilders.post(POST_OFFER_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

        //then
    }

    @Test
    void should_post_offer_return_status_400_when_offer_time_block_is_null() throws Exception {
        //given
        var  offerToCreate = new OfferDto().market(MarketDto.PRIMARY_RESERVE).timeBlocks(null);
        //when
        mockMvc
                .perform(MockMvcRequestBuilders.post(POST_OFFER_URL)
                        .content(objectMapper.writeValueAsBytes(offerToCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

        //then
    }
    @Test
    void should_post_offer_return_status_400_when_offer_market_is_null() throws Exception {
        //given
        var  offerToCreate = new OfferDto().timeBlocks(List.of());
        //when
        mockMvc
                .perform(MockMvcRequestBuilders.post(POST_OFFER_URL)
                        .content(objectMapper.writeValueAsBytes(offerToCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

        //then
    }
}
