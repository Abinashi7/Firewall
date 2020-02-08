/**
 * This program creates an instance of a current rule
 * @author Abinashi Singh
 */
public class Rules {
    /** Direction of the current rule */
    private String direction;
    /** protocol of the current rule */
    private String protocol;
    /** Port number of the current rule */
    private Port port;
    /** IP address of the current rule */
    private IpAddress ip;

    /**
     * Constructor that takes in all the attributes of a current rule and initiates it to the appropriate fields
     * @param direction Direction of the current rule
     * @param protocol Protocol of the current rule
     * @param port Port number of the current rule
     * @param ip IP address of the current rule
     */
    public Rules(String direction, String protocol, String port, String ip) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = new Port(port);
        this.ip = new IpAddress(ip);
    }

    /**
     * Method to check the incoming rule matches one of the existing rules in our Firewall class
     * @param obj the incoming rule
     * @return true if the current rule matches one of the existing rules in our Firewall class, false otherwise
     */
    public boolean checkEquality(Object obj) {

    if(obj != null){
        Rules queryRule = (Rules) obj;
        return (
                queryRule.direction.equals(this.direction) && queryRule.protocol.equals(this.protocol) &&
                queryRule.port.isValidPort(this.port) && queryRule.ip.isValidIp(this.ip)
        );

    }
        return false;

    }
}