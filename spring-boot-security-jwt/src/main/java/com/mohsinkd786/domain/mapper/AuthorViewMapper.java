package com.mohsinkd786.domain.mapper;

import com.mohsinkd786.domain.dto.AuthorView;
import com.mohsinkd786.domain.model.Author;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public abstract class AuthorViewMapper {

    private UserViewMapper userViewMapper;

    @Autowired
    public void setUserViewMapper(UserViewMapper userViewMapper) {
        this.userViewMapper = userViewMapper;
    }

    public abstract AuthorView toAuthorView(Author author);

    public abstract List<AuthorView> toAuthorView(List<Author> authors);

    @AfterMapping
    protected void after(Author author, @MappingTarget AuthorView authorView) {
        authorView.setCreator(userViewMapper.toUserViewById(author.getCreatorId()));
    }

}
