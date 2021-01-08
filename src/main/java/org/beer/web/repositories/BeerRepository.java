package org.beer.web.repositories;

import java.util.UUID;

import org.beer.web.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
