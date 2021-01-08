package org.beer.web.services;

import java.util.UUID;

import org.beer.web.domain.Beer;
import org.beer.web.mappers.BeerMapper;
import org.beer.web.model.BeerDto;
import org.beer.web.repositories.BeerRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID id) {
		return beerMapper.beerToBeerDto(beerRepository.findById(id).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto dto) {
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(dto)));
	}

	@Override
	public BeerDto updateBeer(UUID id, BeerDto dto) {

		Beer beer = beerRepository.findById(id).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(dto.getBeerName());
		beer.setBeerStyle(dto.getBeerStyle().toString());
		beer.setPrice(dto.getPrice());
		beer.setUpc(dto.getUpc());
		
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

}
