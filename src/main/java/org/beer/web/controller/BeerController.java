package org.beer.web.controller;

import java.util.UUID;

import org.beer.web.model.BeerDto;
import org.beer.web.services.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	private final BeerService beerService;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable(name = "beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(BeerDto dto) {
		return new ResponseEntity<>(beerService.saveNewBeer(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> updateBeer(@PathVariable(name = "beerId") UUID beerId, BeerDto dto) {
		return new ResponseEntity<BeerDto>(beerService.updateBeer(beerId, dto), HttpStatus.NO_CONTENT);
	}
}
