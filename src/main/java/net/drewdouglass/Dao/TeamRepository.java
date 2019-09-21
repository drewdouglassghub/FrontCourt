package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.drewdouglass.Entity.Team;

public interface TeamRepository  extends JpaRepository<Team, Long>{

}
