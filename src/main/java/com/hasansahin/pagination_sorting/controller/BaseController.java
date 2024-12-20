package com.hasansahin.pagination_sorting.controller;

import com.hasansahin.pagination_sorting.utils.CustomPageEntity;
import com.hasansahin.pagination_sorting.utils.PageableRequest;
import com.hasansahin.pagination_sorting.utils.PagerUtil;
import com.hasansahin.pagination_sorting.utils.RootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BaseController {
    public Pageable toPageable(PageableRequest pageableRequest){
        return PagerUtil.toPageable(pageableRequest);
    }

    public <T> CustomPageEntity<T> toCustomPageResponse(Page<?> page, List<T> content){
        return PagerUtil.toCustomPageResponse(page, content);
    }

    public <T>RootEntity<T> ok(T payload){
        return RootEntity.ok(payload);
    }
}
