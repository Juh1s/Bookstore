package sof3.hh.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

    // peritään findAll(), findBy(), deleteById(), save();
}
