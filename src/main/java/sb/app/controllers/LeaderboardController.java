package sb.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sb.app.model.Leaderboard;
import sb.app.service.LeaderboardService;

import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/leaderboard")
@RestController
@CrossOrigin("http://localhost:4200/")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/getrank")
    public ResponseEntity<Map<String, String>> getRanking(@RequestParam String username) {
        return leaderboardService.getRankingByUsername(username);
    }

    @GetMapping("/getallrank")
    public List<Leaderboard> getAllRanking() {
        return leaderboardService.getAllRanking();
    }
}