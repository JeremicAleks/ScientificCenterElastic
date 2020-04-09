package com.elastic.scientificenterelastic.mapper;

import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ScientificAreaMapper.class})
public interface UserMapper {
    UserDTO map(User user);

    User map(UserDTO source);
}
