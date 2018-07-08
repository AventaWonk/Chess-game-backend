package chessGameBackend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAMEDATA")
public class GameData {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    private String pieceSet;

    private int whiteTime;

    private int blacktTime;

    private boolean isFinished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPieceSet() {
        return pieceSet;
    }

    public void setPieceSet(String pieceSet) {
        this.pieceSet = pieceSet;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getWhiteTime() {
        return whiteTime;
    }

    public void setWhiteTime(int whiteTime) {
        this.whiteTime = whiteTime;
    }

    public int getBlacktTime() {
        return blacktTime;
    }

    public void setBlacktTime(int blacktTime) {
        this.blacktTime = blacktTime;
    }
}
