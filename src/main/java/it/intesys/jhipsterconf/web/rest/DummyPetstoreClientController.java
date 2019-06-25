package it.intesys.jhipsterconf.web.rest;

import it.intesys.jhipsterconf.client.petstore.api.ReadPetsApi;
import it.intesys.jhipsterconf.client.petstore.model.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DummyPetstoreClientController {

    private final ReadPetsApi readPetsApi;

    public DummyPetstoreClientController(ReadPetsApi readPetsApi) {
        this.readPetsApi = readPetsApi;
    }

    @GetMapping("/api/pets")
    public List<String> petList(){
        List<Pet> petsFromApis = readPetsApi.listPets(100).getBody();

        return petsFromApis.stream()
            .map(Pet::getName)
            .collect(Collectors.toList());
    }
}
