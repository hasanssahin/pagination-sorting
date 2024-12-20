package com.hasansahin.pagination_sorting.repository;

import com.hasansahin.pagination_sorting.model.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonelRepository extends JpaRepository<Personel,Long> {
    @Query(value = "from Personel")
    Page<Personel> findAllPageable(Pageable pageable);
}
