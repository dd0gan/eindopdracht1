package com.example.eindopdracht.service;

import com.example.eindopdracht.dto.UserDto;
import com.example.eindopdracht.exception.InvalidAuthException;
import com.example.eindopdracht.exception.InvalidFileException;
import com.example.eindopdracht.exception.UserExistedException;
import com.example.eindopdracht.exception.UserIsNotExistedException;
import com.example.eindopdracht.model.Role;
import com.example.eindopdracht.model.SystemFile;
import com.example.eindopdracht.model.User;
import com.example.eindopdracht.repository.RoleRepository;
import com.example.eindopdracht.repository.SystemFileRepository;
import com.example.eindopdracht.repository.UserRepository;
import com.example.eindopdracht.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SystemFileRepository systemFileRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, SystemFileRepository systemFileRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.systemFileRepository = systemFileRepository;
        this.encoder = encoder;
    }

    public UserDto createUser(UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getUsername());
        if (user.isPresent()) {
            throw new UserExistedException("User is existed");
        }

        User toSaveUser = new User();
        toSaveUser.setUsername(userDto.getUsername());
        toSaveUser.setPassword(encoder.encode(userDto.getPassword()));

        Optional<Role> userRole = roleRepository.findById("USER");
        List<Role> roles = Arrays.asList(userRole.get());
        toSaveUser.setRoles(roles);
        toSaveUser = userRepository.save(toSaveUser);
        return userDto;
    }

    public UserDto uploadCv(MultipartFile file) throws Exception {
        User userContext = getLoggedInUser();

        Optional<User> uo = userRepository.findById(userContext.getUsername());
        User user = uo.orElseThrow(() -> new UserIsNotExistedException("User doesn't existed"));

        SystemFile systemFile = new SystemFile();
        systemFile.setFilename(file.getOriginalFilename());
        systemFile.setCreateDatetime(new Date());
        systemFile.setData(file.getBytes());
        systemFile.setFileId(UUID.randomUUID().toString());
        systemFileRepository.save(systemFile);

        user.setCvUniqueId(systemFile.getFileId());
        user.setCvFilename(systemFile.getFilename());
        userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setCvUniqueId(user.getCvUniqueId());
        userDto.setCvFilename(systemFile.getFilename());
        return userDto;
    }

    public UserDto getMyInfo() {
        User userContext = getLoggedInUser();

        Optional<User> uo = userRepository.findById(userContext.getUsername());
        User user = uo.orElseThrow(() -> new UserIsNotExistedException("User doesn't existed"));

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setCvUniqueId(user.getCvUniqueId());
        userDto.setCvFilename(user.getCvFilename());
        return userDto;
    }

    @Transactional
    public SystemFile downloadCv(String fileId) {
        User userContext = getLoggedInUser();

        Optional<User> uo = userRepository.findById(userContext.getUsername());
        User user = uo.orElseThrow(() -> new UserIsNotExistedException("User doesn't existed"));

        SystemFile systemFile = systemFileRepository.findByFileId(fileId);
        if (systemFile == null) {
            throw new InvalidFileException("File doesn't existed");
        }
        return systemFile;
    }

    public User getLoggedInUser() {
        try {
            User userContext = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
            return userContext;
        } catch (Exception ex) {
            throw new InvalidAuthException("Invalid user token");
        }
    }
}
