package fr.paris8.iutmontreuil.frameworkProject.authentication.domain;

import fr.paris8.iutmontreuil.frameworkProject.authentication.Mapper.UserMapper;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll(){

        return userDao.findAll()
                        .stream()
                        .map(UserMapper::entityToUser)
                        .collect(Collectors.toList());
    }



    @Transactional
    public void create(UserCreationRequest userCreationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationRequest.username());
        userEntity.setPassword(passwordEncoder.encode(null/*userCreationRequest.password()*/));
        UserEntity savedUser = userDao.save(userEntity);

        List<AuthorityEntity> authorities = new ArrayList<>();
     //   authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId())));
        savedUser.setAuthorities(authorities);

        userDao.save(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
        /*UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));*/
    }

}