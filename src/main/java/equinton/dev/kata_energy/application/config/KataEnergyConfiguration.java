package equinton.dev.kata_energy.application.config;

import equinton.dev.kata_energy.domain.port.CreateOfferOutPort;
import equinton.dev.kata_energy.domain.service.CreateOfferService;
import equinton.dev.kata_energy.domain.service.CreateOfferUserCase;
import equinton.dev.kata_energy.storage.adapter.SaveOfferOutPortAdpater;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KataEnergyConfiguration {

    @Bean
    CreateOfferOutPort getCreateOfferOutPort() {
    return new SaveOfferOutPortAdpater();
    }

    @Bean
    CreateOfferUserCase getCreateOfferUsecase(CreateOfferOutPort createOfferOutPort) {
        return new CreateOfferService(createOfferOutPort);
    }
}
