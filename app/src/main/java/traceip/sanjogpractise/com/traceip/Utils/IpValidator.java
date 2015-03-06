package traceip.sanjogpractise.com.traceip.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by g40 on 3/6/2015.
 */
public class IpValidator
{
    private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IpValidator(){
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    /**
     * Validate ip address with regular expression
     * @param  ip address for validation
     * @return true valid ip address, false invalid ip address
     */
    public static boolean isValidIP(String ipAddr){

        Pattern ptn = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        Matcher mtch = ptn.matcher(ipAddr);
        return mtch.find();
    }

}

