package chessGameBackend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Calendar;

/**
 * OAuth 2.0 token model
 *
 * @author Roman
 */
@Entity
@Table(name = "TOKEN")
public class Token {

    private String token;

    private Calendar expiresAt;

    @OneToOne
    @JoinColumn
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Calendar expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", expiresAt=" + expiresAt.getTime() +
                ", userId" + user.getId() +
                '}';
    }
}
