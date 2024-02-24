package sof3.hh.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>{

    // peritään findAll(), findBy(), deleteById(), save();
}
