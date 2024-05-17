package prodMS.CRUD.service.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prodMS.CRUD.dto.UserDto;
import prodMS.CRUD.entity.User;
import prodMS.CRUD.mapper.UserMapper;
import prodMS.CRUD.repository.UserRepository;
import prodMS.CRUD.service.UserService;
@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User userEntity = UserMapper.mapToUser(userDto);
        User saveUser = userRepository.save(userEntity);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User userEntity = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User does not exist with the given " + userId));
        return UserMapper.mapToUserDto(userEntity);
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            System.out.println("Retrieved password from database: " + user.getPassword());
            System.out.println("Provided password: " + userDto.getPassword());
            if (user.getPassword().equals(userDto.getPassword())) {
                return UserMapper.mapToUserDto(user);
            } else {
                System.out.println("Passwords do not match.");
            }
        } else {
            System.out.println("User with email " + userDto.getEmail() + " not found.");
        }
        return null;
    }

}



