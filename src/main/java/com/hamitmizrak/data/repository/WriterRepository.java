package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.WriterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//1
public interface WriterRepository extends CrudRepository<WriterEntity,Long> {
}
