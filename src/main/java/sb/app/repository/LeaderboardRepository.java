package sb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.app.model.Leaderboard;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, String> {
    Leaderboard findByUsername(String username);
}