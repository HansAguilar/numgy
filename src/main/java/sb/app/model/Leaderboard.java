package sb.app.model;


import javax.persistence.*;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaderboard_id;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public int getLeaderboard_id() {
        return leaderboard_id;
    }

    public void setLeaderboard_id(int leaderboard_id) {
        this.leaderboard_id = leaderboard_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
