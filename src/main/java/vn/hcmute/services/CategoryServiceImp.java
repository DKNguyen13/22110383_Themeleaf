package vn.hcmute.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.hcmute.entity.Category;
import vn.hcmute.reponsitory.CategoryReponsitory;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryReponsitory categoryReponsitory;

    public CategoryServiceImp(CategoryReponsitory categoryReponsitory) {
        this.categoryReponsitory = categoryReponsitory;
    }

    @Override
    public long count() {
        return categoryReponsitory.count();
    }

    @Deprecated
    @Override
    public Category getById(Long aLong) {
        return categoryReponsitory.getById(aLong);
    }

    @Override
    public List<Category> findAll() {
        return categoryReponsitory.findAll();
    }

    @Override
    public List<Category> findAll(Sort sort) {
        return categoryReponsitory.findAll(sort);
    }

    @Override
    public <S extends Category> S save(S entity) {
        return categoryReponsitory.save(entity);
    }

    @Override
    public Page<Category> findByNameContaining(String name, Pageable pageable) {
        return categoryReponsitory.findByNameContaining(name, pageable);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryReponsitory.findByName(name);
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryReponsitory.findById(aLong);
    }

    public void delete(Category entity) {
        categoryReponsitory.delete(entity);
    }
}
