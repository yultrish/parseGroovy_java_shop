package prodMS.CRUD.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prodMS.CRUD.dto.UserDto;
import prodMS.CRUD.service.UserService;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        try {
            UserDto saveUser = userService.createUser(userDto);
            return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        UserDto loggedInUser = userService.loginUser(userDto);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getEmployeeById(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserById(userId);
        System.out.println(userDto);
        return ResponseEntity.ok(userDto);
    }
}
