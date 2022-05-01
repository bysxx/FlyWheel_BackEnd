package com.flywheel.project.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 테이블로 매핑하지 않고, 자식 Entity에게 매핑정보를 상속하기 위한 애노테이션
@EntityListeners(AuditingEntityListener.class) // JPA에게 해당 Entity는 Auditing기능을 사용하는 것을 알림.
public abstract class Time { // 데이터 조작 시 자동으로 날짜 수정
    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
