import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * This program creates an instance of the IP Address with it's ranges
 * @author Abinashi Singh
 */
public class IpAddress {
    /**  Start range of the IP Address*/
    private String startRange;
    /**  end range of the IP Address if any */
    private String endRange;

    /**
     * Constructore that takes in a IPV4 and decides the end and start range according to the input
     * @param ipAddress the IPV4 address
     */
    public IpAddress(String ipAddress){
        // if there contains a "-" in the address then it means it has a range
        if(ipAddress.contains("-")){
            String[] ranges = ipAddress.split("-");

            this.startRange = ranges[0];
            this.endRange = ranges[1];
        }else{ // there is no range, so both the start and end range will be the same
            this.startRange = ipAddress;
            this.endRange = ipAddress;
        }
    }

    /**
     * Method to convert IP address into long type to compare
     * @param ip the IP address
     * @return converted ipAddress
     * Source: madan172: https://gist.github.com/madan712/6651967
     */
    private static long ipToLong(InetAddress ip) {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    /**
     * Method to check if a given IP address falls in a particular range. First, current rule's and incoming IP address are converted
     * into long. In the next step, ipToCheck will be checked if it falls between the range of ipStart and ipEnd
     * @param ipStart the start range of a current IP address that exists as a rule in the Firewall
     * @param ipEnd the end range of a current IP address that exists as a rule in the Firewall
     * @param ipToCheck the incoming IP address that is being checked if it passes the existing rule
     * @return true if ipToCheck is in one of Firewall rules.
     *  Source: madan172: https://gist.github.com/madan712/6651967
     */
    private static boolean isValidRange(String ipStart, String ipEnd,
                                       String ipToCheck) {
        try {
            long ipLo = ipToLong(InetAddress.getByName(ipStart));
            long ipHi = ipToLong(InetAddress.getByName(ipEnd));
            long ipToTest = ipToLong(InetAddress.getByName(ipToCheck));
            return (ipToTest >= ipLo && ipToTest <= ipHi);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Getter to get the start range of the IP address
     * @return the start range of the IP address
     */
    private String getStartRange(){
        return this.startRange;
    }
    /**
     * Getter to get the end range of the IP address
     * @return the end range of the IP address
     */
    private String getEndRangeRange(){
        return this.endRange;
    }

    /**
     * Method to check if the incoming ip address is valid
     * @param ip the incoming ip address
     * @return true if ipToCheck is in one of Firewall rules, false otherwise.
     */

    public boolean isValidIp(IpAddress ip){
        return isValidRange(this.getStartRange(), this.getEndRangeRange(), ip.getStartRange());
    }

}
