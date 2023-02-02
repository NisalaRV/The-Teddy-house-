package lk.ijse.TeddyHouse.to;

public class Customer {
      private String Address;
      private String CustomerId;
      private String Name;
      private String MobileNo;

     public Customer(String address, String customerId, String name, String mobileNo) {
          setAddress(address);
          setCustomerId(customerId);
          setName(name);
          setMobileNo(mobileNo);
     }

     public Customer() {
     }

     public String getAddress() {
          return Address;
     }

     public void setAddress(String address) {
          Address = address;
     }

     public String getCustomerId() {
          return CustomerId;
     }

     public void setCustomerId(String customerId) {
          CustomerId = customerId;
     }

     public String getName() {
          return Name;
     }

     public void setName(String name) {
          Name = name;
     }

     public String getMobileNo() {
          return MobileNo;
     }

     public void setMobileNo(String mobileNo) {
          MobileNo = mobileNo;
     }

     @Override
     public String toString() {
          return "Customer{" +
                  "Address='" + Address + '\'' +
                  ", CustomerId='" + CustomerId + '\'' +
                  ", Name='" + Name + '\'' +
                  ", MobileNo='" + MobileNo + '\'' +
                  '}';
     }
}





