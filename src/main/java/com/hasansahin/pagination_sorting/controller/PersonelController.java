package com.hasansahin.pagination_sorting.controller;

import com.hasansahin.pagination_sorting.dto.DtoPersonel;
import com.hasansahin.pagination_sorting.model.Personel;
import com.hasansahin.pagination_sorting.service.PersonelService;
import com.hasansahin.pagination_sorting.utils.CustomPageEntity;
import com.hasansahin.pagination_sorting.utils.PageableRequest;
import com.hasansahin.pagination_sorting.utils.RootEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personel")
public class PersonelController extends BaseController {
    private final PersonelService personelService;

    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping("/list/pageable")
    public RootEntity<CustomPageEntity<DtoPersonel>> findAllPageable(@ModelAttribute PageableRequest pageableRequest) {
        Page<Personel> page = personelService.findAllPageable(toPageable(pageableRequest));
        CustomPageEntity<DtoPersonel> customPageEntityResponse = toCustomPageResponse(page, personelService.toDtoList(page.getContent()));
        return ok(customPageEntityResponse);
    }
}
