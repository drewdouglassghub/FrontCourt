package net.drewdouglass.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	/*@Query("from Player p  left join ShootingStats s on p.playerid=s.statsid")
	public List<Player> getAllPlayersAndStats();*/
}
