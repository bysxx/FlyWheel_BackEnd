package com.flywheel.project.service;

import com.flywheel.project.domain.entity.User;
import com.flywheel.project.domain.repository.UserRepository;
import com.flywheel.project.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 회원가입 처리
     *
     * @param userDto
     * @return
     */
    @Transactional
    public Long joinUser(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화 처리
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(userDto.toEntity()).getId();
    }

    /**
     * 상세 정보 조회
     * Security 지정 서비스 이므로 필수 구현
     * @param email
     * @return 사용자의 계정정보와 권한을 갖는 UserDetails 인터페이스 반환
     * @throws UsernameNotFoundException
     */
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
