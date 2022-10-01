package cn.j2go.mall.demo.web;

import cn.j2go.mall.demo.auth.AuthUtil;
import cn.j2go.mall.demo.domain.UserRepo;
import cn.j2go.mall.demo.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    final UserRepo userRepo;

    @GetMapping("/me")
    public UserDTO getMe() {
        return AuthUtil.getCurrentUser().map(UserDTO::of).orElse(null);
    }

    @PostMapping("/me")
    public String me(@Valid @RequestBody UserDTO userDTO) {
        AuthUtil.getCurrentUser().ifPresent(currentUser -> {
            currentUser.setNickname(userDTO.getNickname());
            currentUser.setEmail(userDTO.getEmail());
            currentUser.setPhone(Long.parseLong(userDTO.getPhone()));
            currentUser.setIcon(userDTO.getIcon());
            currentUser.setGender(userDTO.getGender());
            currentUser.setBirthday(userDTO.getBirthday());
            currentUser.setCity(userDTO.getCity());
            currentUser.setJob(userDTO.getJob());
            currentUser.setId(0L);
            currentUser.setEditor(currentUser.getUsername());
            userRepo.save(currentUser);
        });
        return "ok";
    }


}
