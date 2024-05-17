package prodMS.CRUD.mapper;

import prodMS.CRUD.dto.UserDto;
import prodMS.CRUD.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getAge(),
                userEntity.getLocation()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getAge(),
                userDto.getLocation()
        );
    }
}
