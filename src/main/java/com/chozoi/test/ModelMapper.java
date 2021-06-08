package com.chozoi.test;

import com.chozoi.test.app.dtos.*;
import com.chozoi.test.domain.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    UserDTO UserToResponse(User user);

    @Mapping(target = "category_id", source = "category.id")   //1 tasty nhieu category
    TastyDTO TastyToResponse (Tasty tasty);

    @Mapping(target = "user_id", source = "user.id")        //1 cart co nhieu user
    CartDTO CartToResponse (Cart cart);
}
