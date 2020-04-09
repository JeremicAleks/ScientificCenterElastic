package com.elastic.scientificenterelastic.mapper;

import com.elastic.scientificenterelastic.domain.ScientificArea;
import com.elastic.scientificenterelastic.dto.ScientificAreaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScientificAreaMapper {


    ScientificAreaDTO map(ScientificArea scientificArea);

    ScientificArea map(ScientificAreaDTO source);

}
