package sb.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sb.app.dto.UserDTO;

import java.util.Map;

@Service
public interface UserService {
    ResponseEntity<Map<String, String>> registerUser(UserDTO user);

    ResponseEntity<Map<String, String>> loginUser(UserDTO user);
}
