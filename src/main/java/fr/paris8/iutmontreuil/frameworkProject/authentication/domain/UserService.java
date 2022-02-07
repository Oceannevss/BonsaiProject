package fr.paris8.iutmontreuil.frameworkProject.authentication.domain;

import fr.paris8.iutmontreuil.frameworkProject.authentication.Mapper.UserMapper;
import fr.paris8.iutmontreuil.frameworkProject.authentication.exposition.UserDto;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.ChangePasswordRequest;
import fr.paris8.iutmontreuil.frameworkProject.authentication.infrastructure.*;
import fr.paris8.iutmontreuil.frameworkProject.bonsai.infrastructure.DAO.BonsaiDao;
import fr.paris8.iutmontreuil.frameworkProject.owner.domaine.Owner;
import fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure.OwnerDao;
import fr.paris8.iutmontreuil.frameworkProject.owner.infrastructure.OwnerRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
        userEntity.setUsername(userCreationRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));
        UserEntity savedUser = userDao.save(userEntity);

        List<AuthorityEntity> authorities = new ArrayList<>();
        authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId())));
        savedUser.setAuthorities(authorities);

        userDao.save(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

         UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }

    public User changeMyPassword(ChangePasswordRequest changePasswordRequest){

        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        UserEntity userEntity = userDao.getById(credentials.getId());

        boolean isEqualsOldPasswordBase = passwordEncoder.matches(changePasswordRequest.getOldPassword(), credentials.getPassword());
        boolean isEqualsNewPassword = passwordEncoder.matches(changePasswordRequest.getNewPassword(), changePasswordRequest.getNewPasswordConfirmation());
        boolean isEqualsOldNewPassword = passwordEncoder.matches(changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword());

        if(isEqualsOldPasswordBase){
            if(isEqualsNewPassword){
                if(!isEqualsOldNewPassword){
                    userEntity.setPassword(changePasswordRequest.getNewPassword());
                }
            }
        }

        return UserMapper.entityToUser(userDao.save(userEntity));
    }

    public User changeUserAuthority(UUID uuid, ChangeUserAuthorityRequest changeUserAuthorityRequest){

        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        UserEntity userEntityCurrent = userDao.getById(credentials.getId());
        UserEntity userEntity = userDao.getById(uuid);

        List<AuthorityEntity> ListeAuthority = new ArrayList<>();
        AuthorityEntity authorityEntity = new AuthorityEntity();
        AuthorityId authorityId = new AuthorityId();
        authorityId.setAuthority(changeUserAuthorityRequest.getAuthority());
        authorityEntity.setAuthorityId(authorityId);
        ListeAuthority.add(authorityEntity);

        if(userEntityCurrent.getAuthorities().get(0).getAuthority().equals("ADMIN")){
            userEntity.setAuthorities(ListeAuthority);
        }

       return UserMapper.entityToUser(userDao.save(userEntity));
    }

    public List<Owner> getOwners(){
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        UserEntity userEntityCurrent = userDao.getById(credentials.getId());

        if(userEntityCurrent.getAuthorities().get(0).getAuthority().equals("ADMIN")){
            OwnerDao ownerDao = null;
            BonsaiDao bonsaiDao = null;
            OwnerRepository ownerRepository = new OwnerRepository(ownerDao, bonsaiDao);
            return ownerRepository.findAll();
        }

        return null;
    }
}