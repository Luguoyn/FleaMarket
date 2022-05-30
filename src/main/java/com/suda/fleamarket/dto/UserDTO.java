package com.suda.fleamarket.dto;

import com.suda.fleamarket.entity.User;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long userId;
    private String name;
    private Authority authority;
    private Date birthday;
    private Gander gander;
    private String address;
    @Pattern(regexp = "^((13\\d)|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",
            message = "错误的手机号码格式")
    private String telephone;
    @Email(message = "错误的邮箱格式")
    private String email;

    private UserDTO(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.authority = user.getAuthority();
        this.birthday = user.getBirthday();
        this.gander = user.getGander();
        this.address = user.getAddress();
        this.telephone = user.getTelephone();
        this.email = user.getEmail();
    }

    public static UserDTO getFromUser(User user) {
        return new UserDTO(user);
    }

    public User toUser() {
        return User.builder()
                .id(userId).name(name).address(address)
                .authority(authority).birthday(birthday)
                .email(email).gander(gander).telephone(telephone)
                .build();
    }
}
