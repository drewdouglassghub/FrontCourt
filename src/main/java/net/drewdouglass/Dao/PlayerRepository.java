package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.OffensiveStats;
import net.drewdouglass.Entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	Player findByPlayerid(long playerid);
	Player findByOffensiveStats(OffensiveStats stats);
	void delete(Player playerid);
	
}
