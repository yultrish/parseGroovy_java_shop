package prodMS.CRUD.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prodMS.CRUD.dto.UserDto;

//@Service
//@AllArgsConstructor
public interface UserService {
    UserDto createUser (UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto loginUser (UserDto userDto);
}
