package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.drewdouglass.Entity.OffensiveStats;

public interface OffenseRepo extends JpaRepository<OffensiveStats, Long>{


	OffensiveStats findById(long id);


}
