package com.backengtest.demo.mapper;

import com.backengtest.demo.dto.UserDto;
import com.backengtest.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProjectMapper.class)

public interface UserMapper {
    //@Mapping(target = "")
    UserDto mapUserToDto(User user);
    User mapUserDtoToEntity(UserDto userDto);
}
