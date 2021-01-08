package org.beer.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

// beer avec pagination
public class BeerPagedList extends PageImpl<BeerDto> {

	public BeerPagedList(@JsonProperty(value = "content")List<BeerDto> content,
						@JsonProperty(value="number") int number, 
						@JsonProperty(value = "size")int size, 
						@JsonProperty(value = "totalElements")Long totalElements, 
						@JsonProperty(value = "pageable")JsonNode pageable,
						@JsonProperty(value = "last")boolean last, 
						@JsonProperty(value = "totalPages")int totalPages,
						@JsonProperty(value = "sort")JsonNode sort,
						@JsonProperty(value = "first")boolean first, 
						@JsonProperty(value = "numberOfElements")int numberOfElements) {
		super(content, PageRequest.of(number, size), totalElements);

	}

	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerPagedList(List<BeerDto> content) {
		super(content);
	}
}
