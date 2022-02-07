package fr.paris8.iutmontreuil.frameworkProject.authentication.exposition;

import fr.paris8.iutmontreuil.frameworkProject.authentication.Mapper.UserMapper;
import fr.paris8.iutmontreuil.frameworkProject.authentication.domain.UserService;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.ChangePasswordRequest;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.ChangeUserAuthorityRequest;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.UserCreationRequest;
import fr.paris8.iutmontreuil.frameworkProject.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.frameworkProject.owner.exposition.OwnerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDto> findAll() {

        return userService.findAll()
                            .stream()
                            .map(UserMapper::userToDto)
                            .collect(Collectors.toList());
    }

    @PostMapping
    public void create (@RequestBody UserCreationRequest createRequest){

        userService.create(createRequest);
    }

    @PutMapping("/me/password")
    public void changeMyPassword(@RequestBody ChangePasswordRequest changePasswordRequest){

        userService.changeMyPassword(changePasswordRequest);

    }

    @PutMapping("/users/{uuid}/authority")
    public void changeUserAuthority(@PathVariable UUID uuid, @RequestBody ChangeUserAuthorityRequest changeUserAuthorityRequest){

        userService.changeUserAuthority(uuid, changeUserAuthorityRequest);
    }

    /*@GetMapping
    public List<UserDto> GetUsers(@RequestBody UserDto userDto ){

        return List<UserDto>;
    }*/

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser (@RequestBody UserDto userDto){

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/owners")
    public List<OwnerDTO> getOwners (@RequestBody OwnerDTO ownerDTO){

         return userService.getOwners()
                                .stream()
                                .map(OwnerMapper::ownerToDto)
                                .collect(Collectors.toList());
    }

}
