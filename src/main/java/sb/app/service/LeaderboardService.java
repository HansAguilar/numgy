package sb.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface LeaderboardService {
    ResponseEntity<Map<String, String>> getRankingByUsername(String username);
}
