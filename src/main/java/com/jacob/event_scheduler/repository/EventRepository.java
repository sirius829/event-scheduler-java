package com.jacob.event_scheduler.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jacob.event_scheduler.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Derived Query: Find events where the title contains the given keyword.
    List<Event> findByTitleContaining(String keyword);

    @Query("SELECT e FROM Event e WHERE e.startTime > :currentTime")
    List<Event> findUpcomingEvents(@Param("currentTime") LocalDateTime currenTime);
}
