package kr.ai.kjun.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUsers(List<UserDTO> users) {
        userRepository.saveUsers(users);
    }

    public void printUsers() {
        userRepository.printUsers();
    }
}
