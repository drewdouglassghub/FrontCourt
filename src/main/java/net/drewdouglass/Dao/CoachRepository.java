package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.Coach;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Long>{

}

