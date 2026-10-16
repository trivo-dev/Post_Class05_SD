import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private final List<Integer> aCards = new ArrayList<>();

    public Deck() {
        for (int i = 1; i <= 52; i++) {
            aCards.add(i);
        }
        System.out.println("  [Deck] Tạo bộ bài mới");
    }

    public void shuffle() {
        Collections.shuffle(aCards);
    }

    public List<Integer> top(int n) {
        return aCards.subList(0, n);
    }
}

class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    private final Deck aDeck = new Deck();

    private GameModel() {
        System.out.println("  [GameModel] Constructor được gọi");
    }

    public static GameModel instance() {
        return INSTANCE;
    }

    public void newGame() {
        aDeck.shuffle();
    }

    public Deck deck() {
        return aDeck;
    }
}

public class Exercise09 {
    public static void main(String[] args) {
        System.out.println("1. Bắt đầu main (GameModel chưa được nạp)");

        System.out.println("2. Gọi GameModel.instance() lần đầu:");
        GameModel g1 = GameModel.instance();

        System.out.println("3. Gọi GameModel.instance() lần hai:");
        GameModel g2 = GameModel.instance();
        System.out.println("   g1 == g2 ? " + (g1 == g2));

        System.out.println("4. Chơi 3 ván, cùng một bộ bài được xáo lại:");
        for (int i = 1; i <= 3; i++) {
            GameModel.instance().newGame();
            System.out.println("   Ván " + i + ", 5 lá trên cùng: "
                    + GameModel.instance().deck().top(5));
        }

        // GameModel g3 = new GameModel(); // Lỗi biên dịch: GameModel() has private access
        System.out.println("5. new GameModel() bị chặn ở thời điểm biên dịch (constructor private)");
    }
}
