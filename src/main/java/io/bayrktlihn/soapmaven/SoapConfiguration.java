package io.bayrktlihn.soapmaven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {


    @Bean
    Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("io.bayrktlihn.soap.ws.client");
        return marshaller;
    }

    @Bean
    SoapClient soapClient(Jaxb2Marshaller marshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);
        return soapClient;
    }
}
