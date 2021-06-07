package com.mohsinkd786.domain.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ObjectIdMapper {

    public String objectIdToString(ObjectId objectId) {
        return objectId.toString();
    }

    public ObjectId stringToObjectId(String string) {
        return new ObjectId(string);
    }

}
