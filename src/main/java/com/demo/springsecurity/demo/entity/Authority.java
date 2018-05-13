package com.demo.springsecurity.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authority {

    @Embeddable
    private static class AuthorityTableCompositeKey implements Serializable {
        private String username;
        private String authority;

        public AuthorityTableCompositeKey() {
        }

        public AuthorityTableCompositeKey(String username, String authority) {
            this.username = username;
            this.authority = authority;
        }
    }

    @EmbeddedId
    private AuthorityTableCompositeKey key = new AuthorityTableCompositeKey();

    public String getUsername() {
        return key.username;
    }

    public String getAuthority() {
        return key.authority;
    }
}

