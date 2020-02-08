import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;


public class Tests {

    @Test
    public static void checkInvalidPorts(Firewall input){

        assertFalse(input.accept_packet("inbound", "udp", 0, "52.12.48.92" ));
        assertFalse(input.accept_packet("inbound", "udp", 1, "192.168.10.11" ));
        assertFalse(input.accept_packet("inbound", "udp", 70000, "10.10.10.2" ));

    }

    @Test
    public static void checkInvalidIps(Firewall input){
        assertFalse(input.accept_packet("inbound", "udp", 1024, "0.0.0.0" ));
        assertFalse(input.accept_packet("inbound", "udp", 1000, "256.168.10.11" ));
        assertFalse(input.accept_packet("inbound", "udp", 99, "11.10.10.2" ));
    }

    @Test
    public static void testingRangesPort(Firewall input){
        assertTrue(input.accept_packet("inbound", "tcp", 1025, "10.10.1.2" ));
        assertTrue(input.accept_packet("inbound", "tcp", 3579, "192.168.1.2" ));
        assertTrue(input.accept_packet("inbound", "tcp", 3579, "11.11.1.2" ));
        assertFalse(input.accept_packet("inbound", "tcp", 3580, "11.11.1.2" ));

    }

    @Test
    public static void testingRangesIp(Firewall input){
        assertFalse(input.accept_packet("inbound", "tcp", 546, "9.10.1.2" ));
        assertTrue(input.accept_packet("inbound", "tcp", 546, "11.11.5.1" ));
        assertTrue(input.accept_packet("inbound", "tcp", 546, "11.11.5.2" ));
        assertFalse(input.accept_packet("inbound", "tcp", 546, "192.168.11.2" ));
    }



    public static void main(String[] args) throws IOException {
        Scanner path = new Scanner(System.in);
        System.err.println("Please enter the path to your CSV file");

        Firewall firewall = new Firewall(path.next());

        // testing invalid ports
        checkInvalidPorts(firewall);
        // testing invalid ips
        checkInvalidIps(firewall);
        // testing range of ports
        testingRangesPort(firewall);
        // testing range of ips
        testingRangesIp(firewall);
    }
}