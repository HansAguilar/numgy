package sb.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import sb.app.dto.UserDTO;
import sb.app.service.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private static final String UPLOAD_DIR = "C://Users//Kukis//Desktop//spring-boot-prac//sample-rest//files//";

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }


    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> upload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> response = new HashMap<>();

        if(file.isEmpty()){
            response.put("message", "Upload failed!");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());

            if(!Files.exists(path)){
                Path directory = Paths.get(UPLOAD_DIR);
                Files.createDirectories(directory);
            }

            Files.write(path, bytes);
            response.put("message", "Image successfully upload");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("user/{name}")
    public String getUserByID(@PathVariable String name) {
        return String.format("You got %s", name);
    }

    @GetMapping("consume-url/{id}")
    public RedirectView getImage(@PathVariable String id, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://www.reddit.com/r/learnjava/comments/13pozdk/what_are_some_fun_and_interesting_projects_that/");
        return redirectView;
    }

    @GetMapping("/gets")
    public String getUserByIDs(@RequestParam(defaultValue = "lol", value = "name") String name) {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Define the URL of your Spring Boot API endpoint
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/10"; // Replace with your actual API endpoint URL

        // Make a GET request to the API endpoint and retrieve the response
        String response = restTemplate.getForObject(apiUrl, String.class);

        // Print the response
        System.out.println("Response: " + response);
        return response;
    }
}
