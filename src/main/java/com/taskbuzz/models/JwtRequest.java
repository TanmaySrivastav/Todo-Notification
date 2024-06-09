package com.taskbuzz.models;

public class JwtRequest {
    private String email;
    private String password;

    private JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static JwtRequestBuilder builder() {
        return new JwtRequestBuilder();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class JwtRequestBuilder {
        private String email;
        private String password;

        private JwtRequestBuilder() {
        }

        public JwtRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public JwtRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public JwtRequest build() {
            return new JwtRequest(email, password);
        }
    }
}
