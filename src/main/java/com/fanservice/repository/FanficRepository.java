package com.fanservice.repository;

import com.fanservice.model.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FanficRepository extends JpaRepository<Fanfic, UUID> {
}
