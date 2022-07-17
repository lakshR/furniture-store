package com.furnitureStore.Dao;
import com.furnitureStore.entity.Furniture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FurnitureDao extends CrudRepository<Furniture,Long> {
}
