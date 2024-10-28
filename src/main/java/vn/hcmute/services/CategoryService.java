package vn.hcmute.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.hcmute.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    long count();

    @Deprecated
    Category getById(Long aLong);

    List<Category> findAll();

    List<Category> findAll(Sort sort);

    <S extends Category> S save(S entity);

    Page<Category> findByNameContaining(String name, Pageable pageable);

    Optional<Category> findByName(String name);

    Optional<Category> findById(Long aLong);
    void delete(Category entity);
}
