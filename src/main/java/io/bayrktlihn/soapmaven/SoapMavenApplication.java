package io.bayrktlihn.soapmaven;

import io.bayrktlihn.soap.ws.client.ExecuteVposRequest;
import io.bayrktlihn.soap.ws.client.ExecuteVposRequestResponse;
import io.bayrktlihn.soap.ws.client.VposRequest;
import io.bayrktlihn.soap.ws.client.VposResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapMavenApplication implements CommandLineRunner {

    @Autowired
    private SoapClient soapClient;

    public static void main(String[] args) {
        SpringApplication.run(SoapMavenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        ExecuteVposRequest executeVposRequest = new ExecuteVposRequest();
        VposRequest vposRequest = new VposRequest();
        vposRequest.setMerchantId("deneme");
        vposRequest.setPassword("1232132");
        vposRequest.setCardHoldersName("alihan bayraktar");
        vposRequest.setCvv("111");
        vposRequest.setPan("5454545454545454");
        executeVposRequest.setVposRequest(vposRequest);

        ExecuteVposRequestResponse o = soapClient.callSoapService("https://onlineodemetest.vakifbank.com.tr:4443/VposService/TransactionServices.asmx", "PayFlexVPosWebService/ExecuteVposRequest", executeVposRequest);

        VposResponse vposResponse = o.getExecuteVposRequestResult();

        System.out.println(vposResponse.getResultCode());
        System.out.println(vposResponse.getResultDetail());

    }
}
