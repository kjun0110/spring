package kr.ai.kjun.api.user.service;

import java.util.List;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;


public interface UserService {

    public Messenger saveAll(List<UserDTO> users);
    public Messenger save(UserDTO userDto);
    public Messenger update(UserDTO userDto);
    public Messenger delete(String id);
    public Messenger findById(String id);
    public Messenger findAll();
}
