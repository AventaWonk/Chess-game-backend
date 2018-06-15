package chessGameBackend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "GAMEDATA")
public class GameData {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    private String pieceSet;

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public GameData setId(int id) {
        this.id = id;
        return this;
    }

    public String getPieceSet() {
        return pieceSet;
    }

    public GameData setPieceSet(String pieceSet) {
        this.pieceSet = pieceSet;
        return this;
    }

    public User getUser() {
        return user;
    }

    public GameData setUser(User user) {
        this.user = user;
        return this;
    }
}
