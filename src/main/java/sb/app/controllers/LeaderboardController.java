package sb.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sb.app.service.LeaderboardService;

import java.util.Map;

@RequestMapping("api/v1/leaderboard")
@RestController
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/{username}")
    public ResponseEntity<Map<String, String>> getRanking(@PathVariable String username) {
        return leaderboardService.getRankingByUsername(username);
    }
}