package sb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.app.dto.UserDTO;
import sb.app.model.User;
import sb.app.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<Map<String, String>> registerUser(UserDTO userDTO) {
        User _user = new User(userDTO.username,userDTO.password);

        userRepository.save(_user);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Successfully Registered");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> loginUser(UserDTO userDTO) {
        User _user = userRepository.findByUsername(userDTO.username);

        Map<String,String> response = new HashMap<>();
        if(_user == null){
            response.put("message", "User not found");
            return ResponseEntity.status(404).body(response);
        }

        if (!_user.getPassword().equals(userDTO.password)) {
            response.put("message", "Incorrect password");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Successfully Logged In");
        return ResponseEntity.ok(response);
    }


}
