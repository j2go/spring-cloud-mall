package cn.j2go.mall.demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends CrudRepository<User, Long> {
    UserDetails findByUsername(String username);
}
