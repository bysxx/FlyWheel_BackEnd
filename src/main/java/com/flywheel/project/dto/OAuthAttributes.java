/*
package com.flywheel.project.dto;

import com.flywheel.project.domain.entity.Role;
import com.flywheel.project.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userName;
    private String nickName;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String userName,
                           String nickName,
                           String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .userName((String) attributes.get("userName"))
                .nickName((String) attributes.get("nickName"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .nickName(nickName)
                .email(email)
                .role(Role.GUEST)
                .build();
    }
}
*/
