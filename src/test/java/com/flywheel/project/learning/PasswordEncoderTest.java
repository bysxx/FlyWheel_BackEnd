package com.flywheel.project.learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PasswordEncoderTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    private static String PASSWORD = "신동훈ShinDongHun";

    @Test
    public void 패스워드_암호화() throws Exception {

        //when
        String encodePassword = passwordEncoder.encode(PASSWORD);

        //then
        assertThat(encodePassword).startsWith("{");
        assertThat(encodePassword).contains("{bcrypt}");
        assertThat(encodePassword).isNotEqualTo(PASSWORD);

    }

    @Test
    public void 패스워드_랜덤_암호화() throws Exception {

        //when
        String encodePassword = passwordEncoder.encode(PASSWORD);
        String encodePassword2 = passwordEncoder.encode(PASSWORD);

        //then
        assertThat(encodePassword).isNotEqualTo(encodePassword2);

    }


    @Test
    public void 암호화된_비밀번호_매치() throws Exception {

        //when
        String encodePassword = passwordEncoder.encode(PASSWORD);

        //then
        assertThat(passwordEncoder.matches(PASSWORD, encodePassword)).isTrue();

    }
}
