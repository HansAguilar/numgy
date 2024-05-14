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
        User _user = new User(
                userDTO.username,
                userDTO.password
        );

        userRepository.save(_user);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Successfully Registered");
        return ResponseEntity.ok(response);
    }
}
