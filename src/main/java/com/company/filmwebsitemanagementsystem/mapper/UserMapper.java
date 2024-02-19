package com.company.filmwebsitemanagementsystem.mapper;

import com.company.filmwebsitemanagementsystem.model.dto.request.UserRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.UserResponse;
import com.company.filmwebsitemanagementsystem.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserResponse mapToUserResponseFromUser(User user);

    User mapToUserFromUserRequest(UserRequest request);

@Mapping(target = "id", ignore = true)
@Mapping(target = "active", ignore = true)
    User mapForUpdate(@MappingTarget User user, UserRequest request);


}
