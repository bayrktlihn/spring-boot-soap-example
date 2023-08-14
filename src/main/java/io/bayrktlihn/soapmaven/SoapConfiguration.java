package io.bayrktlihn.soapmaven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

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
        soapClient.setDefaultUri("https://onlineodemetest.vakifbank.com.tr:4443/VposService/TransactionServices.asmx");
        soapClient.setInterceptors(new ClientInterceptor[]{new SoapInterceptor()});
        return soapClient;
    }
}
