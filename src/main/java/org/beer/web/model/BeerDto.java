package org.beer.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerDto {

	@Null // ne doit pas etre generer par client
	private UUID id;

	@Null
	private Integer version;

	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime createdDate;

	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime lastModifiedDate;

	@NotBlank // ne doit pas se persister en db vide
	private String beerName;

	@NotNull
	private BeerStyleEnum beerStyle;

	@NotNull
	private String upc;

	@JsonFormat(shape = Shape.STRING) // format de json=> "price":"12.99"
	@Positive
	@NotNull
	private BigDecimal price;

	private Integer quantityOnHand;
}
