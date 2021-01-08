package org.beer.web.mappers;

import org.beer.web.domain.Beer;
import org.beer.web.model.BeerDto;
import org.mapstruct.Mapper;

// mapstruct fournit une implementation BeerMapperImpl disponible dans le runtime 
// tout en utilisant la conversion les date

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

	// conv depuis un dto vers une entity beer
	public Beer beerDtoToBeer(BeerDto dto);

	// conv depuis un entity beer to dto
	public BeerDto beerToBeerDto(Beer beer);
}
