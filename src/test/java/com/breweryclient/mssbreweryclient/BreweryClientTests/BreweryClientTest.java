package com.breweryclient.mssbreweryclient.BreweryClientTests;

import com.breweryclient.mssbreweryclient.client.BreweryClient;
import com.breweryclient.mssbreweryclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.net.URI;
import java.util.UUID;


@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById(){
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }
    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        //it is void method
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

//    When we add @ResponseStatus(HttpStatus.BAD_REQUEST) in deleteBeerById in the beer service side we here get a error
    @Test
    void testDeleteBeer(){
        //it is void method
        client.deleteBeer(UUID.randomUUID());
    }
}
