package com.suda.fleamarket.dto;

import com.suda.fleamarket.entity.Security;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityDTO implements FMDTO<Security> {
    private Long id;
    private String loginName;
    private String password;

    private String newPassword;
    private Long userId;

    public SecurityDTO(Security security) {
        this.id = security.getId();
        this.userId = security.getUserId();
        this.loginName = security.getLoginName();
        this.password = security.getPassword();
    }

    public static SecurityDTO getFromEntity(Security entity) {
        return new SecurityDTO(entity);
    }

    @Override
    public Security toEntity() {
        return Security.builder().loginName(loginName).password(password).userId(userId).id(id).build();
    }
}
