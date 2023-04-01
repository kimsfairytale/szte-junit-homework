package org.junittraining.exercise;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * This is a placeholder for your tests!
 */
public class IPAddressCalculationsTest {

    private IPAddressCalculationsImpl IPAddressConverter;

    @Before
    public void setUp() throws Exception {
        IPAddressConverter = new IPAddressCalculationsImpl();
    }

    @Test
    public void testValidIPAddressWithHome() {
        assertThat(IPAddressConverter.ipAddressToIPNumber("192.168.0.1")).isEqualTo(3232235521L);
    }

    @Test
    public void testValidIPAddressWithBroadcast() {
        assertThat(IPAddressConverter.ipAddressToIPNumber("255.255.255.255")).isEqualTo(4294967295L);
    }

    @Test
    public void testValidIPAddressWithPlaceholder() {
        assertThat(IPAddressConverter.ipAddressToIPNumber("0.0.0.0")).isEqualTo(0L);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressString() {
        IPAddressConverter.ipAddressToIPNumber("invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressFirstBad() {
        IPAddressConverter.ipAddressToIPNumber("256.0.0.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressSecondBad() {
        IPAddressConverter.ipAddressToIPNumber("0.256.0.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressThirdBad() {
        IPAddressConverter.ipAddressToIPNumber("0.0.256.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressFourthBad() {
        IPAddressConverter.ipAddressToIPNumber("0.0.0.256");
    }    

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressNegativeAndRangeBad() {
        IPAddressConverter.ipAddressToIPNumber("-3.458.1026.-398");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIPAdressMoreNumbers() {
        IPAddressConverter.ipAddressToIPNumber("420.69.42.4.33");
    }

}
