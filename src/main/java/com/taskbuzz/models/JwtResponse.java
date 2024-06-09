package com.taskbuzz.models;

public class JwtResponse {
    private String JwtToken;  // Note: Field name with "JwtToken"
    private String username;

    private JwtResponse(String JwtToken, String username) {
        this.JwtToken = JwtToken;
        this.username = username;
    }

    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public String getJwtToken() {
        return JwtToken;
    }

    public String getUsername() {
        return username;
    }

    public static class JwtResponseBuilder {
        private String JwtToken;  // Note: Variable name without "Jwt" prefix
        private String username;

        private JwtResponseBuilder() {
        }

        public JwtResponseBuilder JwtToken(String JwtToken) {
            this.JwtToken = JwtToken;
            return this;
        }

        public JwtResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(JwtToken, username);
        }
    }
}
