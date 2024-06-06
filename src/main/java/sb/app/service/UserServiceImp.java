package sb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.app.dto.UserDTO;
import sb.app.model.Leaderboard;
import sb.app.model.User;
import sb.app.repository.LeaderboardRepository;
import sb.app.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Map<String, String>> registerUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.username);
        Map<String,String> response = new HashMap<>();

        if(user != null){
            response.put("message", "Username already taken");
            return ResponseEntity.ok(response);
        }

        else{
//            String hashedPassword = passwordEncoder.encode(userDTO.password);
            User _user = new User(userDTO.username, userDTO.password);

            userRepository.save(_user);
            response.put("message", "Successfully Registered");
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> loginUser(UserDTO userDTO) {
        User _user = userRepository.findByUsername(userDTO.username);

        Map<String,String> response = new HashMap<>();
        if(_user == null){
            response.put("message", "User not found");
            return ResponseEntity.status(404).body(response);
        }

        if (userDTO.password.equals(_user.getPassword())) {
            response.put("message", "Incorrect password");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Successfully Logged In");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> updateUserHistory(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.username);

        Map<String, String> response = new HashMap<>();

        if (user != null) {
            // Increment the user's total played count
            user.setTotal_games_played(user.getTotal_games_played() + 1);
            user.setOverall_score(user.getOverall_score() + userDTO.overall_score);

            // Save the updated user entity to persist the changes
            userRepository.save(user);

            // Check if the user already has an entry in the leaderboard
            Leaderboard leaderboard = leaderboardRepository.findByUsername(userDTO.username);

            if (leaderboard == null) {
                // If the user does not have an entry in the leaderboard, create a new one
                leaderboard = new Leaderboard();
                leaderboard.setUser(user);
            } else {
                // If the user already has an entry, update the existing one
                // Assuming the leaderboard keeps track of the user's current score or other metrics
            }

            leaderboardRepository.save(leaderboard);

            response.put("message", "Updated user history successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "User not found");
            return ResponseEntity.status(404).body(response);
        }
    }

}
