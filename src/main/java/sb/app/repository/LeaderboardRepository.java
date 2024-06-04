package sb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sb.app.model.Leaderboard;

import java.util.List;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    @Query("SELECT l FROM Leaderboard l JOIN l.user u WHERE u.username = :username")
    Leaderboard findByUsername(@Param("username") String username);

    @Query("SELECT l FROM Leaderboard l JOIN l.user u ORDER BY u.overall_score DESC")
//    @Query("SELECT Leaderboard.*, user.overall_score FROM leaderboard JOIN User ON Leaderboard.leaderboard_id = ser.id ORDER BY user.overall_score ASC")
    List<Leaderboard> findAllRank();
}