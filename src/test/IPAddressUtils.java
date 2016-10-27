package test;

import java.text.Format;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressUtils
{
    private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
    private static final String SLASH_FORMAT = IP_ADDRESS + "/(\\d{1,3})";
    public static final Pattern ADDRESS_PATTERN = Pattern.compile(IP_ADDRESS);
    private static final Pattern CIDR_PATTERN = Pattern.compile(SLASH_FORMAT);
    
    private long mNetmask = 0;
    private long mAddress = 0;
    private long mNetwork = 0;
    private long mBroadcast = 0;
    private static final int ADDRESS_BITS = 32;
    private static final long UNSIGNED_INT_MASK = 0x0FFFFFFFFL;
    
    public static void main(String[] args)
    {
        IPAddressUtils t = new IPAddressUtils("192.0.2.0/24");
       
    }
    
    
    /*
     * Convert a packed integer address into a 4-element array
     */
    private int[] toArray(int val) {
        int ret[] = new int[4];
        for (int j = 3; j >= 0; --j) {
            ret[j] |= ((val >>> 8*(3-j)) & (0xff));
        }
        return ret;
    }
    private String format(int[] octets) {
        StringBuilder str = new StringBuilder();
        for (int i =0; i < octets.length; ++i){
            str.append(octets[i]);
            if (i != octets.length - 1) {
                str.append(".");
            }
        }
        return str.toString();
    }
    
    /**
     * Calculates mask for all special IPs
     * 
     * @param cdirAddress address in CIDR representation
     */
    public IPAddressUtils(String cdirAddress)
    {
        calculate(cdirAddress);
        
        System.out.println(isInRange(toLong("192.0.2.1")));
        
        System.out.println(format(toArray((int)mNetwork)));
        System.out.println(format(toArray((int)mNetmask)));
        System.out.println(format(toArray((int)mBroadcast)));
        System.out.println(format(toArray((int)mAddress)));
    }
    
    /**
     * Initialize the internal fields from the supplied CIDR mask
     * 
     * @param mask address
     * 
     */
    private void calculate(String mask)
    {
        Matcher matcher = CIDR_PATTERN.matcher(mask);
        
        if (matcher.matches())
        {
            mAddress = matchAddress(matcher);
            
            int cidrPart = rangeCheck(Integer.parseInt(matcher.group(5)), 0, ADDRESS_BITS);
            for (int j = 0; j < cidrPart; ++j)
            {
                mNetmask |= (1 << 31 - j);
            }
            
            mNetwork = (mAddress & mNetmask);
            
            mBroadcast = mNetwork | ~(mNetmask);
        }
        else
        {
            throw new IllegalArgumentException("Could not parse [" + mask + "]");
        }
    }
    
    /**
     * Checks if the provided address is in range of restricted ips
     * 
     * @param addressToCheck input address
     * @return true if in range false if not
     */
    public boolean isInRange(long addressToCheck)
    {
        long addLong = addressToCheck & UNSIGNED_INT_MASK;
        long lowLong = low() & UNSIGNED_INT_MASK;
        long highLong = high() & UNSIGNED_INT_MASK;
        System.out.println(lowLong + " :"+addLong
            
             + " "+highLong );
        return addLong >= lowLong && addLong <= highLong;
        
    }
    
    /**
     * Checks and return the maximum allowed limit
     * 
     * @return upper limit
     */
    private long high()
    {
        return mBroadcast - mNetwork > 1 ? mBroadcast - 1 : 0;
    }
    
    /**
     * Checks and return the minimum allowed limit
     * 
     * @return lower limit
     */
    private long low()
    {
        
        return mBroadcast - mNetwork > 1 ? mNetwork + 1 : 0;
    }
    
    /**
     * 
     * @param matcher Matcher to be matched
     * @return address long/integer representation of IP address
     */
    public static long matchAddress(Matcher matcher)
    {
        long addr = 0;
        for (int i = 1; i <= 4; ++i)
        {
            int n = (rangeCheck(Integer.parseInt(matcher.group(i)), 0, 255));
            System.out.println(n);
            addr |= ((n & 0xff) << 8 * (4 - i));
        }
        System.out.println(addr);
        return addr;
    }
    
    /**
     * Convenience function to check integer boundaries.
     * Checks if a value x is in the range [begin,end].
     * Returns x if it is in range, throws an exception otherwise.
     * 
     * @param value to compare
     * @param begin starting
     * @param end end
     * @return range integer value
     * @throws IllegalArgumentException
     */
    public static int rangeCheck(int value, int begin, int end)
    {
        if (value >= begin && value <= end)
        { // (begin,end]
            return value;
        }
        
        throw new IllegalArgumentException("Value [" + value + "] not in range [" + begin + "," + end + "]");
    }
    
    /**
     * 
     * @param address address to convert
     * @return address long/integer representation of IP address
     */
    public static long toLong(String address)
    {
        Matcher matcher = ADDRESS_PATTERN.matcher(address);
        if (matcher.matches())
        {
            return matchAddress(matcher);
        }
        else
        {
            throw new IllegalArgumentException("Could not parse [" + address + "]");
        }
    }
    
}