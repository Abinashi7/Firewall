/**
 * This program creates an instance of the port number with it's ranges
 * @author Abinashi Singh
 */
public class Port {

    /**  Start range of the port number*/
    private int startRange;
    /** end range of the port number if any */
    private int endRange;


    /**
     * Constructore that takes in a port number and decides the end and start range according to the input
     * @param portNum the port number
     */
    public Port(String portNum){
        // if there contains a "-" then it means it has a range
        if(portNum.contains("-")){
            String[] ranges = portNum.split("-");

            this.startRange = Integer.parseInt(ranges[0]);
            this.endRange = Integer.parseInt(ranges[1]);
        }else{ // there is no range, so both the start and end range will be the same
            this.startRange = Integer.parseInt(portNum);
            this.endRange = Integer.parseInt(portNum);
        }
    }

    /**
     * Getter to get the start range of the port number
     * @return the start range of the port
     */
    private int getStartRange(){
        return this.startRange;
    }
    /**
     * Getter to get the end range of the port number
     * @return the end range of the port
     */
    private int getEndRangeRange(){
        return this.endRange;
    }

    /**
     * Check whether the current port number exists in one of the rules of the Firewall
     * @param port the current port number
     * @return true if port number exists in one of the rules of the Firewall, false otherwise
     */
    public boolean isValidPort(Port port){
        // flag to check the status
        boolean flag = false;
        if(port.getStartRange() >= this.getStartRange() && port.getEndRangeRange() <= this.getEndRangeRange()){
            flag = true;
        }
        return flag;
    }
}
