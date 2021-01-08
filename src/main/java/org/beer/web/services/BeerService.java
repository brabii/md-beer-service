package org.beer.web.services;

import java.util.UUID;

import org.beer.web.model.BeerDto;

public interface BeerService {
	
	BeerDto getById(UUID id);

	BeerDto saveNewBeer(BeerDto dto);

	BeerDto updateBeer(UUID id, BeerDto dto);
}
