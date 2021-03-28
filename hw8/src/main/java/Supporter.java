public class Supporter {

  private String first_name;
  private String last_name;
  private String company_name;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phone1;
  private String phone2;
  private String email;
  private String webUrl;

  public Supporter(String first_name, String last_name, String company_name, String address,
      String city, String county, String state, String zip, String phone1, String phone2,
      String email, String webUrl) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.company_name = company_name;
    this.address = address;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.webUrl = webUrl;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getCompany_name() {
    return company_name;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getCounty() {
    return county;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public String getPhone1() {
    return phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getEmail() {
    return email;
  }

  public String getWebUrl() {
    return webUrl;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Supporter{");
    sb.append("first_name='").append(first_name).append('\'');
    sb.append(", last_name='").append(last_name).append('\'');
    sb.append(", company_name='").append(company_name).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", city='").append(city).append('\'');
    sb.append(", county='").append(county).append('\'');
    sb.append(", state='").append(state).append('\'');
    sb.append(", zip='").append(zip).append('\'');
    sb.append(", phone1='").append(phone1).append('\'');
    sb.append(", phone2='").append(phone2).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", webUrl='").append(webUrl).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
