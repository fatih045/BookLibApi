package com.example.demo07_12_2023;

import com.example.demo07_12_2023.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  @Mapping(source = "id",target = "id")
  UserDto userToUserDto(User user);

}
