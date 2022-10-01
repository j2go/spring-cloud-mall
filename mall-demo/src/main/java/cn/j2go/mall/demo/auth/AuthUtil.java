package cn.j2go.mall.demo.auth;

import cn.j2go.mall.demo.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuthUtil {
    public static Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof User user) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
