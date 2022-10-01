package cn.j2go.mall.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@Table(name = "user", indexes = {@Index(name = "ix_username", columnList = "username", unique = true)})
public class User extends BaseEntity implements UserDetails {

    private String username;

    private String password;

    private String nickname;
    
    private String email;

    private Long phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    private Integer status = 0;

    /**
     * 头像
     */
    private String icon = "";

    /**
     * 性别：0->未知；1->男；2->女
     */
    private Byte gender = 0;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 城市
     */
    private String city;

    /**
     * 职业
     */
    private String job;

    /**
     * 用户来源
     */
    private String source;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status > 0;
    }
}
