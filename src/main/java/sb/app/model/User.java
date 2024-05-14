package sb.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private int overall_score;
    private int total_games_played;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.overall_score = 0; // default value
        this.total_games_played = 0; // default value
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(int overall_score) {
        this.overall_score = overall_score;
    }

    public int getTotal_games_played() {
        return total_games_played;
    }

    public void setTotal_games_played(int total_games_played) {
        this.total_games_played = total_games_played;
    }
}
