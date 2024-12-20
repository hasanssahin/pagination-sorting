package com.hasansahin.pagination_sorting.service;

import com.hasansahin.pagination_sorting.dto.DtoDepartment;
import com.hasansahin.pagination_sorting.dto.DtoPersonel;
import com.hasansahin.pagination_sorting.model.Personel;
import com.hasansahin.pagination_sorting.repository.PersonelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    public Page<Personel> findAllPageable(Pageable pageable) {
        return personelRepository.findAllPageable(pageable);
    }

    public List<DtoPersonel> toDtoList(List<Personel> personelList) {
        DtoPersonel dtoPersonel = new DtoPersonel();
        DtoDepartment dtoDepartment = new DtoDepartment();
        return personelList.stream().map(personel -> {
            BeanUtils.copyProperties(personel, dtoPersonel);
            BeanUtils.copyProperties(personel.getDepartment(), dtoDepartment);
            dtoPersonel.setDepartment(dtoDepartment);
            return dtoPersonel;
        }).toList();
    }
}
