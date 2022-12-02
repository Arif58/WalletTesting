package WalletImprove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    String owner;
    HashMap<Integer, Integer> coins;
    HashMap<Integer, Integer> moneys;
    List<String> cards;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }

    public HashMap<Integer, Integer> getMoneys() {
        return moneys;
    }

    public void setCoins(HashMap<Integer, Integer> coins) {
        this.coins = coins;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }
    int[] coinTypes = {100, 500, 1000};
    int[] moneyTypes = {1000, 2000, 5000, 10000, 20000, 50000, 100000};

    public Wallet() {
        this.coins = new HashMap<Integer, Integer>();
        this.coins.put(100, 0);
        this.coins.put(500, 0);
        this.coins.put(1000, 0);

        this.moneys = new HashMap<Integer, Integer>();
        this.moneys.put(1000, 0);
        this.moneys.put(2000, 0);
        this.moneys.put(5000, 0);
        this.moneys.put(10000, 0);
        this.moneys.put(20000, 0);
        this.moneys.put(50000, 0);
        this.moneys.put(100000, 0);

        this.cards = new ArrayList<String>();
    }

    void insertCoin(Integer type) {
        boolean isCoinValid = false;

        for (int i=0; i<coinTypes.length; i++) {
            if (type == coinTypes[i]) {
                isCoinValid = true;
            }
        }
        if (isCoinValid) {
            int initialValue = this.coins.get(type);
//            System.out.println(initialValue);
            this.coins.put(type, initialValue + 1);
        }
    }

    void insertMoneys(Integer type) {
        boolean isMoneyValid = false;

        for (int i=0; i<moneyTypes.length; i++) {
            if (type == moneyTypes[i]) {
                isMoneyValid = true;
            }
        }
        if (isMoneyValid) {
            int initialValue = this.moneys.get(type);
            this.moneys.put(type, initialValue + 1);
        }
    }

    void takeCoins(Integer type) {
        int initialValue = this.coins.get(type);
        this.coins.put(type, initialValue - 1);
    }

    void takeMoneys(Integer type) {
        int initialValue = this.moneys.get(type);
        this.moneys.put(type, initialValue - 1);
    }

    void addCard(String card) {
        this.cards.add(card);
    }

    void takeCard(String card) {
        for (int i = 0; i < this.cards.size(); i++) {
            this.cards.remove(card);
        }
    }

    public int calculateCoins() {
        int total = 0;

        for (Integer key : this.coins.keySet()) {
            total += key * this.coins.get(key);
        }
        return total;
    }

    public int calculateMoneys() {
        int total = 0;
        for (Integer key : this.moneys.keySet()) {
            total += key * this.moneys.get(key);
        }
        return total;
    }
}
