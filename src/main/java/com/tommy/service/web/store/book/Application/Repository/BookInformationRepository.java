package com.tommy.service.web.store.book.Application.Repository;

import java.util.ArrayList;

import com.tommy.service.web.store.book.Application.Entity.BookInformation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("bookinformationRepository")
public interface BookInformationRepository extends CrudRepository<BookInformation, Long>{
	
	//Reference: https://www.baeldung.com/spring-data-jpa-query#2-native-3
	
	@Query(value = "SELECT * FROM BookInformation WHERE isbn = :isbn", nativeQuery = true)
	BookInformation findByISBN(@Param("isbn") String isbn);
	
	@Query(value = "SELECT * FROM BookInformation WHERE :type = :query", nativeQuery = true)
	ArrayList<BookInformation> findByType(@Param("type") String type, @Param("query") String query);
	
	@Query(value = "DELETE FROM BookInformation WHERE isbn = :isbn", nativeQuery = true)
	void deleteByISBN(@Param("isbn") String isbn);
	
}