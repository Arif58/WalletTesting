package WalletImprove;

import org.junit.*;

import java.util.Optional;

import static org.junit.Assert.*;

public class WalletTest {

//    static Wallet dompet;
//
//    @BeforeClass
//    public static void setClassup() {
//        dompet = new Wallet();
//    }

    Wallet dompet = new Wallet();

    @Before
    public void setUp() throws Exception {
        dompet.owner = "Marple";
        dompet.insertCoin(500);
        dompet.insertCoin(100);
        dompet.insertCoin(500);
        dompet.insertMoneys(2000);
        dompet.insertMoneys(10000);
        dompet.addCard("KTP");
        dompet.addCard("STNK");
    }

    @Test
    public void getOwnerTest() {
        Assert.assertEquals("Marple", dompet.getOwner());
    }

    @Test
    public void setOwnerTest() {
        dompet.setOwner("Boni");
        Assert.assertEquals("Boni", dompet.getOwner());
    }

    @Test
    public void insertCoinTest() {
        dompet.insertCoin(500);
        Assert.assertEquals(Optional.of(3), Optional.of(dompet.getCoins().get(500)));
    }

    @Test
    public void takeCoinsTest() {
        dompet.takeCoins(100);
        Assert.assertEquals(Optional.of(0), Optional.of(dompet.getCoins().get(100)));
    }

    @Test
    public void addCardTest() {
        dompet.addCard("SIM");
        Assert.assertEquals(3, dompet.getCards().size());
    }

    @Test
    public void takeCardTest() {
        dompet.takeCard("KTP");
        Assert.assertEquals(1, dompet.getCards().size());
    }

    @Test
    public void calculateCoinsTest() {
        Assert.assertEquals(1100, dompet.calculateCoins());
    }

    @Test
    public void insertMoneyTest() {
        Assert.assertEquals(Optional.of(1), Optional.of(dompet.getMoneys().get(2000)));
    }

    @Test
    public void takeMoneyTest() {
        dompet.takeMoneys(2000);
        Assert.assertEquals(Optional.of(0), Optional.of(dompet.getMoneys().get(2000)));
    }

    @Test
    public void calculateMoneysTest() {
        Assert.assertEquals(12000, dompet.calculateMoneys());
    }

}