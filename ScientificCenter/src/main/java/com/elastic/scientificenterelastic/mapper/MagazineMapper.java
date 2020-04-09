package com.elastic.scientificenterelastic.mapper;

import com.elastic.scientificenterelastic.domain.Magazine;
import com.elastic.scientificenterelastic.dto.MagazineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ScientificAreaMapper.class,UserMapper.class})
public interface MagazineMapper {
    MagazineDTO map(Magazine magazine);

    Magazine map(MagazineDTO source);

}
