import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class WalletTest {
    Wallet rama = new Wallet();

    @Test
    public void setOwner() {
        rama.setOwner("Nizan Tanboy Kun");
        Assert.assertNotNull(rama.getOwner());
    }

    @Test
    public void addCard() {
        rama.addCard("KTM");
        rama.addCard("KTP");
        Assert.assertEquals("KTP", rama.showCards().get(1));
    }

    @Test
    public void addUang() {
        rama.addUang(100000);
        rama.addUang(5000);
        rama.addUang(500);
        rama.addUang(100);
        Assert.assertNotNull(rama.showTotalUang());
    }

    @Test
    public void totalUang() {
        rama.addUang(10000);
        rama.addUang(20000);
        rama.addUang(500);
        Assert.assertEquals(30500, rama.showTotalUang());
    }

    @Test
    public void takeCard() {
        rama.addCard("KTP");
        rama.addCard("KTM");
        rama.addCard("SIM");
        rama.takeCard("KTM");
        Assert.assertEquals("SIM", rama.showCards().get(1));
    }

    @Test
    public void takeUang() {
        rama.addUang(10000);
        rama.addUang(5000);
        rama.takeUang(2000);
        rama.takeUang(500);
        Assert.assertEquals(12500, rama.showTotalUang());
    }
}