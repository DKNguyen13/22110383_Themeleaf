package vn.hcmute.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.hcmute.entity.Category;

import java.util.Optional;

public interface CategoryReponsitory extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Page<Category> findByNameContaining(String name, Pageable pageable);

}
