package org.junittraining.exercise;

public class IPAddressCalculationsImpl implements IPAddressCalculations {

    @Override
    public long ipAddressToIPNumber(String ipAddress) throws IllegalArgumentException {
        
        String[] blocks = ipAddress.split("\\.");

        if (blocks.length != 4) {
            throw new IllegalArgumentException("Invalid IP address format.");
        }
    
        int w = Integer.parseInt(blocks[0]);
        int x = Integer.parseInt(blocks[1]);
        int y = Integer.parseInt(blocks[2]);
        int z = Integer.parseInt(blocks[3]);
    
        if (w < 0 || w > 255 || x < 0 || x > 255 || y < 0 || y > 255 || z < 0 || z > 255) {
            throw new IllegalArgumentException("Invalid IP address range.");
        }
    
        return (16777216L * w) + (65536L * x) + (256L * y) + z;
    }
    
}
