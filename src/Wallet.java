import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String owner;
    private ArrayList<String> cards;
    private ArrayList<Integer> moneys;
    private ArrayList<Integer> coins;

    public Wallet() {
        this.cards = new ArrayList<>();
        this.moneys = new ArrayList<Integer>();
        this.coins = new ArrayList<Integer>();
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public void addUang(Integer uang) {
        if (uang >= 1000){
            this.moneys.add(uang);
        }
        else if (uang > 0) {
            this.coins.add(uang);
        }
        else {
            System.out.println("Uang tidak bisa minus");
        }
    }

    public void takeUang(Integer uang) {
        if (uang >= 1000){
            this.moneys.add(-uang);
        }
        else if (uang > 0) {
            this.coins.add(-uang);
        }
    }

    public Integer sumMoneys() {
        Integer total = 0;
        for (int i=0; i<this.moneys.size(); i++) {
            total += this.moneys.get(i);
        }
        return total;
    }

    public Integer sumCoins() {
        Integer total = 0;
        for (int i=0; i<this.coins.size(); i++) {
            total += this.coins.get(i);
        }
        return total;
    }

    public long showTotalUang() {
        Integer totalUang;
        totalUang = sumMoneys() + sumCoins();
        return totalUang;
    }

    public ArrayList<String> showCards() {
        return cards;
    }

    public String getOwner() {
        return owner;
    }

    public void takeCard(String card) {
        this.cards.remove(card);
    }
}
