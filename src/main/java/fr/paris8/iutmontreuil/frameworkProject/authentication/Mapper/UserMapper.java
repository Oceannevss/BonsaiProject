package fr.paris8.iutmontreuil.frameworkProject.authentication.Mapper;

import fr.paris8.iutmontreuil.frameworkProject.authentication.domain.User;
import fr.paris8.iutmontreuil.frameworkProject.authentication.exposition.UserDto;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAuthorities(userDto.getAuthorities().stream().collect(Collectors.toList()));
        return user;
    }

    public static User entityToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
    //    user.setAuthorities(userEntity.getAuthorities().stream().collect(Collectors.toList()));
        return user;
    }

    public static UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
       // userDto.setAuthorities(user.getAuthorities().stream().collect(Collectors.toList()));
        return userDto;
    }

    public static UserEntity userToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
      //  userEntity.setAuthorities(user.getAuthorities().stream().collect(Collectors.toList()));
        return userEntity;
    }

}
