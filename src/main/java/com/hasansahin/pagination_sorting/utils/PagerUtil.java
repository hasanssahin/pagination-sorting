package com.hasansahin.pagination_sorting.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public final class PagerUtil {
    private PagerUtil() {
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static Pageable toPageable(PageableRequest pageableRequest){
        if(!isNullOrEmpty(pageableRequest.getColumnName())){
            Sort sortBy=pageableRequest.isAsc() ? Sort.by(Sort.Direction.ASC, pageableRequest.getColumnName()) : Sort.by(Sort.Direction.DESC, pageableRequest.getColumnName());
            return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize(), sortBy);
        }
        return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize());
    }

    public static <T> CustomPageEntity<T> toCustomPageResponse(Page<?> page, List<T> content){
        CustomPageEntity<T> customPageEntity = new CustomPageEntity<>();
        customPageEntity.setContent(content);
        customPageEntity.setPageNumber(page.getPageable().getPageNumber());
        customPageEntity.setPageSize(page.getPageable().getPageSize());
        customPageEntity.setTotalElements(page.getTotalElements());
        return customPageEntity;
    }
}
