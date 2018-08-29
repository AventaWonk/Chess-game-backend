package chessGameBackend.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Calendar;

/**
 * OAuth 2.0 token model
 *
 * @author Roman
 */
@Entity
@Table(name = "TOKEN")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NaturalId
    private String token;

    @Temporal(TemporalType.DATE)
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
