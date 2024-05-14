package sb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.app.model.Leaderboard;
import sb.app.repository.LeaderboardRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class LeaderboardServiceImp implements LeaderboardService {
    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Override
    public ResponseEntity<Map<String, String>> getRankingByUsername(String username) {
        Map<String,String> response = new HashMap<>();

        response.put("message", username);
        return ResponseEntity.ok().body(response);
    }

//    @Override
//    public ResponseEntity<Map<String, String>> getRankingByUsername(String username) {
//        Leaderboard leaderboard = leaderboardRepository.findByUsername(username);
//
//        Map<String, String> response = new HashMap<>();
//        if (leaderboard != null) {
//            response.put("username", leaderboard.getUsername().getUsername());
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("message", "User not found in leaderboard");
//            return ResponseEntity.status(404).body(response);
//        }
//    }
}
