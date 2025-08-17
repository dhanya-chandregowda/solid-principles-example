package com.example.application.mapper;

import com.example.application.dto.ActivityDto;
import com.example.application.entity.Activity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ActivityMapper {

    public ActivityDto toDTO(Activity activity){

       return ActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .price(activity.getPrice())
                .currency(activity.getCurrency())
                .rating(activity.getRating())
                .specialOffer(activity.isSpecialOffer())
                .supplierName(Objects.isNull(activity.getSupplier().getName())? "": activity.getSupplier().getName() )
                .build();
    }
}
