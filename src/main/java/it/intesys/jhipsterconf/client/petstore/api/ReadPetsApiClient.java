package it.intesys.jhipsterconf.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;
import it.intesys.jhipsterconf.client.petstore.ClientConfiguration;

@FeignClient(name="${petstore.name:petstore}", url="${petstore.url:http://localhost:8083/api-first}", configuration = ClientConfiguration.class)
public interface ReadPetsApiClient extends ReadPetsApi {
}