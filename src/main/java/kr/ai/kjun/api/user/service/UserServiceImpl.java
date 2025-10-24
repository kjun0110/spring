package kr.ai.kjun.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;

    @Override
    public Messenger saveAll(List<UserDTO> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Messenger save(UserDTO userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public Messenger update(UserDTO userDto) {
        return userRepository.update(userDto);
    }

    @Override
    public Messenger delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return userRepository.findAll();
    }
}
