package com.flywheel.project.dto;

import com.flywheel.project.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
public class UserDto {

    private String email;
    private String password;
    private String auth;

    @Builder
    public UserDto(String email, String password, String auth) {
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    /* DTO -> Entity */
    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .auth(auth)
                .build();
    }
}
