package com.creditsuisse.eventfilereader.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.creditsuisse.eventfilereader.model.Event;


/**
 * It makes CRUD from Event
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
