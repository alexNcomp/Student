package Student;

/**
 * Class of Address.
 * @author Alex Nguyen
 */
class Address {
    private String apartNum;
    private String streetName;
    private String streetNum;
    private String cityName;
    private String province;
    private String zipcode;

    public Address() {
        this.apartNum = null;
        this.streetName = null;
        this.streetNum = null;
        this.cityName = null;
        this.province = null;
        this.zipcode = null;
    }

    public Address(String apartNum, String streetName, String streetNum, String 
            cityName, String province, String zipcode) {
        this.apartNum = apartNum;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.cityName = cityName;
        this.province = province;
        this.zipcode = zipcode;
    }
    
    public Address(Address address) {
        this.apartNum = address.apartNum;
        this.streetName = address.streetName;
        this.streetNum = address.streetNum;
        this.cityName = address.cityName;
        this.province = address.province;
        this.zipcode = address.zipcode;
    }
    
    /**
     * Checks if the zip code is valid. Needs to follow a pattern: A1A 1A1.
     * @param zipcode The zip code 
     * @return True if it is a valid zip code, false if not.
     */
    public static boolean isZipcodeValid(String zipcode) {
        if (zipcode.length() != 7)
            return false;
        for (int i = 0; i < zipcode.length(); i++) {
            if ((i == 0 || i == 2 || i == 5) && !Character.isLetter(zipcode.charAt(i)))
                return false;
            if ((i == 1 || i == 4 || i == 6) && !Character.isDigit(zipcode.charAt(i)))
                return false;
            if (i == 3 && zipcode.charAt(i) != ' ')
                return false;
        }
        return true;
    }
    
    public boolean equals(Address address) {
        return this.apartNum.equals(address.apartNum) &&
                this.streetName.equals(address.streetName) &&
                this.streetNum.equals(address.streetNum) &&
                this.cityName.equals(address.cityName) &&
                this.province.equals(address.province) &&
                this.zipcode.equals(address.zipcode);
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("\t%s, %s %s\n", apartNum, streetName, streetNum);
        str += String.format("\t%s %s, %s", cityName, province, zipcode);
        
        return str;
    }

    public String getApartNum() {
        return apartNum;
    }

    public void setApartNum(String apartNum) {
        this.apartNum = apartNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        if (isZipcodeValid(zipcode))
            this.zipcode = zipcode.toUpperCase();
        else 
            System.out.printf("%s: %s\n", "Invalid zip code", zipcode);
    }
}
