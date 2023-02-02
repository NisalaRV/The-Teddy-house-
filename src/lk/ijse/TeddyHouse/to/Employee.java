package lk.ijse.TeddyHouse.to;

public class Employee {
    private String EmployeeId;
    private String Name;
    private String IdCardNumber;
    private String Address;
    private String MobileNo;

    public Employee(String employeeId, String name, String idCardNumber, String address, String mobileNo) {
        setEmployeeId(employeeId);
        setName(name);
        setIdCardNumber(idCardNumber);
        setAddress(address);
        setMobileNo(mobileNo);
    }

    public Employee() {
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdCardNumber() {
        return IdCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        IdCardNumber = idCardNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", Name='" + Name + '\'' +
                ", IdCardNumber='" + IdCardNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", MobileNo='" + MobileNo + '\'' +
                '}';
    }
}
