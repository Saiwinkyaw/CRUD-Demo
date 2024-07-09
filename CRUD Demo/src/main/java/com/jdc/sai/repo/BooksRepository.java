package com.jdc.sai.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdc.sai.dao.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>{

}
