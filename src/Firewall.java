import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This program creates a set of rules present in the CSV file
 * @author Abinashi Singh
 */
public class Firewall {
    /**
     * Set to store the rules
     */
    private Set<Rules> Map;


    /**
     * Constructor that takes in a String argument(path) which is a csv file.
     * Initializes a Set which will store the rules while reading from the CSV file
     * @param path the path to the CSV file
     * @throws IOException in case of invalid input
     */
    public Firewall(String path) throws IOException {

        this.Map = new HashSet<>();
        read(path);
    }

    /**
     * Method to read the CSV file and store it in Set
     * @param path the String type path to the CSV file
     * @throws IOException in case of invalid input
     */
    private void read(String path) throws IOException {

        File csvFile = new File(path);
        // to check if given path contains a valid file
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            // reading row by row in the CSV file
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] rules = row.split(",");
                Map.add(new Rules(rules[0], rules[1], rules[2], rules[3]));
            }
            // close the file after it reaches the end
            csvReader.close();
        }else{
            System.err.println("Please enter the valid path to a valid file");
        }

    }


    /**
     * Method to check if the incoming rules matches our own defined rules in the Firewall
     * @param direction an inbound/outbound file
     * @param protocol a transfer protocol is udp/tcp
     * @param port the port number
     * @param ip_address the IPV4 address
     * @return true if the current input matches the rules of Firewall, false otherwise
     */
    public boolean accept_packet(String direction, String protocol, int port, String ip_address){
        // iterator to iterate over the Firewall rules
        Iterator<Rules> itr = Map.iterator();
        // create an instance of the incoming file
        Rules curRule = new Rules(direction, protocol, String.valueOf(port), ip_address);

        // check if curRule matches our Firewall's rule by iterating over all the existing rules one by one
        while (itr.hasNext()){
             if(curRule.checkEquality(itr.next())){
                 return true;
             }
        }
        return false;
    }
}
