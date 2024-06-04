package sb.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.app.model.Leaderboard;

import java.util.List;
import java.util.Map;

@Service
public interface LeaderboardService {
    ResponseEntity<Map<String, String>> getRankingByUsername(String username);
//    ResponseEntity<Map<String, String>> getAllRanking();
    List<Leaderboard> getAllRanking();
}

