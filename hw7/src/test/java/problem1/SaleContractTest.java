package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaleContractTest {
  private SaleContract contract;

  @Before
  public void setUp() throws Exception {
    contract = new SaleContract(400000.0, false);
  }

  @Test
  public void getTotalPrice() {
    assertEquals(400000, contract.getTotalPrice(), 0.01);
  }
}