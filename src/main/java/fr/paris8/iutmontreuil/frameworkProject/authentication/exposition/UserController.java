package fr.paris8.iutmontreuil.frameworkProject.authentication.exposition;

import fr.paris8.iutmontreuil.frameworkProject.authentication.Mapper.UserMapper;
import fr.paris8.iutmontreuil.frameworkProject.authentication.domain.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

    }

    @GetMapping
    public List<UserDto> findAll() {

        return userService.findAll().stream().map(UserMapper::userToDto).collect(Collectors.toList());
    }
}
