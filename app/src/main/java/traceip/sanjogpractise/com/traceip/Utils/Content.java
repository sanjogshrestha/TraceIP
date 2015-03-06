package traceip.sanjogpractise.com.traceip.Utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by g40 on 3/6/2015.
 */
public class Content
{
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /* {
            "ip": "103.1.93.11",
                "country_code": "NP",
                "country_name": "Nepal",
                "region_code": "1",
                "region_name": "Central Region",
                "city": "Kathmandu",
                "zip_code": "",
                "time_zone": "Asia/Kathmandu",
                "latitude": 27.717,
                "longitude": 85.317,
                "metro_code": 0
        }*/
    @SerializedName("ip")
    public String ip;

    @SerializedName("country_name")
    public String country_name;

    @SerializedName("region_name")
    public String region_name;

    @SerializedName("city")
    public String city;

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @SerializedName("zip_code")
    public String zip_code;

    @SerializedName("time_zone")
    public String time_zone;

    @SerializedName("latitude")
    public Double latitude;

    @SerializedName("longitude")
    public Double longitude;


}
