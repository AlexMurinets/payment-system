package com.alex.payment.backend.service;

import com.alex.payment.backend.dto.UserDto;
import com.alex.payment.backend.model.User;
import com.alex.payment.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllStudents () {
        return userRepository.findAll();
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User doesn't exist."));
    }

    public UserDto fromUserToUserDto(User user) {
        if (Objects.isNull(user))
            throw new IllegalArgumentException("Invalid user.");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public User fromUserDtoToUser(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        if(Objects.isNull(user))
            throw new IllegalArgumentException("User with username: "+userDto.getUsername()+" doesn't exist.");
        return user;
    }
}
