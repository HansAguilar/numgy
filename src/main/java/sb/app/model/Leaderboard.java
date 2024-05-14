package sb.app.model;

import javax.persistence.*;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaderboard_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User username;

    public int getLeaderboard_id() {
        return leaderboard_id;
    }

    public void setLeaderboard_id(int leaderboard_id) {
        this.leaderboard_id = leaderboard_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
