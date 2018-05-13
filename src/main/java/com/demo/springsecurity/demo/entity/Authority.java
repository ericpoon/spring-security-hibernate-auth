package com.demo.springsecurity.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authority {

    @Embeddable
    private static class AuthorityTableCompositeKey implements Serializable {
        @ManyToOne
        @JoinColumn(name="username")
        private User user;

        private String authority;

        @Override
        public String toString() {
            return "AuthorityTableCompositeKey{" +
                    "username='" + user.getUsername() + '\'' +
                    ", authority='" + authority + '\'' +
                    '}';
        }
    }

    @EmbeddedId
    private AuthorityTableCompositeKey key = new AuthorityTableCompositeKey();

    public String getUsername() {
        return key.user.getUsername();
    }

    public String getAuthority() {
        return key.authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "key=" + key +
                '}';
    }

}

