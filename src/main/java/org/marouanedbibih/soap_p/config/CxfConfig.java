package org.marouanedbibih.soap_p.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.marouanedbibih.soap_p.compte.CompteServiceSOAP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class CxfConfig {
    
    private CompteServiceSOAP compteServiceSOAP;
    private Bus bus;

    @Bean
    public EndpointImpl endpointImpl(){
        EndpointImpl endpoint = new EndpointImpl(bus, compteServiceSOAP);
        endpoint.publish("/ws");
        return endpoint;
    }
}
