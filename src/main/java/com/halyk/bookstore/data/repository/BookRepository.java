package com.halyk.bookstore.data.repository;

import com.halyk.bookstore.data.entity.Book;
import com.halyk.bookstore.data.entity.Publisher;
import com.halyk.bookstore.exception.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    default Book findByIdOrThrowException(Long id){
        return findById(id).orElseThrow(()->new EntityNotFoundException("Entity with id = " + id + " not found"));
    }

    Long deleteBookById(Long id);

    List<Book> findBookByName(String name);

    List<Book> findByIdIn(List<Long> bookList);

//    List<Book> findBookByNameAndPublisher(String bookName, String )

    List<Book> findBookByNameLike(String namePart); //todo попробовать сделать через этот метод или сделать через аннотацию query
    //todo добавить Representation для других
}
