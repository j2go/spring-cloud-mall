package cn.j2go.mall.demo.web.dto;

import cn.j2go.mall.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Min(0)
    @Max(2)
    private Byte gender;

    private String username;

    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Size(min = 11, max = 11, message = "电话号码长度不正确")
    @Pattern(regexp = "\\d+", message = "电话号码格式不正确")
    private String phone;

    private String icon;

    private String birthday;

    private String city;

    private String job;

    public static UserDTO of(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getGender(),
                user.getUsername(),
                user.getNickname(),
                user.getEmail(),
                user.getPhone() + "",
                user.getIcon(),

                user.getBirthday(),
                user.getCity(),
                user.getJob()
        );
    }
}
