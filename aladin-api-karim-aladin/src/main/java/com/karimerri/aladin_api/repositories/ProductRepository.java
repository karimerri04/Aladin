/**
 *
 */
package com.karimerri.aladin_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karimerri.aladin_api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
	@Query("UPDATE Product p SET p.isFavorited = :isFavorited WHERE p.id = :id")
	int favoritedProduct(@Param("id") Integer id, @Param("isFavorited") Boolean isFavorited);

	@Query("select p from Product p where p.category.id=:cat_id")
	List<Product> findByCategory(Integer cat_id);

	@Query("SELECT p from Product p WHERE p.isFavorited = :isFavorited")
	List<Product> findByFavorited(@Param("isFavorited") Boolean isFavorited);

	Product findByName(String name);

	Product findBySku(String sku);

	@Query("select p from Product p where p.name like ?1 or p.sku like ?1 or p.description like ?1")
	List<Product> search(String query);

}
