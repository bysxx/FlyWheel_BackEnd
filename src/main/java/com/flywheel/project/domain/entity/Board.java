package com.flywheel.project.domain.entity;

import lombok.*;
import org.springframework.util.Assert;
import javax.persistence.*;

// 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단
// 외부에서의 생성을 열어 둘 필요가 없을 때 / 보안적으로 권장.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board extends Time {

    @Id // PK Field
    @GeneratedValue(strategy= GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // Board가 필드값으로 갖고 있는 User 도메인을 1:1 관계로 설정
    // lazy : User 객체를 조회하는 시점이 아닌 객체가 실제 사용될 때 조회
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder // Java 디자인 패턴, 생성 시점에 값을 채워줌
    public Board(Long id, String title, String content, String writer, User user) {

        // Assert 구문으로 안전한 객체 생성 패턴을 구현
        // writer, title, content 객체가 전달되지 않을 경우 Exception을 발생
        Assert.hasText(writer, "writer must not be empty");
        Assert.hasText(title, "title must not be empty");
        Assert.hasText(content, "content must not be empty");

        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.user = user;
    }
}
