package com.test.contactapp.mappers;

import com.test.contactapp.core.Contact;
import com.test.contactapp.dtos.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

/**
 * @author Swapnil Bagadia
 */

//Null Value Check Strategy sets the value of target field only if correspondiong source field is not null - Important for PUT
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactMapper {


    //@Mapping (target,ignore) is used to ignore updating the P_KEY, even by mistake even if the dto has non null value for it
    @Mapping(target = "contactId", ignore = true)
    Contact toEntity(ContactDto contactDto);

    //DTO to Entity(Updation) ~ Does not create a new object, maps to object passed with @MappingTarget annotation
    @Mapping(target = "contactId", ignore = true)
    Contact toEntity(ContactDto contactDto, @MappingTarget Contact contact);

    ContactDto toDto(Contact contact);
}
