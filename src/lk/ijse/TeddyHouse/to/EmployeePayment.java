package lk.ijse.TeddyHouse.to;

public class EmployeePayment {
    private String PaymentId;
    private String EmployeeId;
    String date;
    private String salary;
    private String PaymentMethod;

    public EmployeePayment(String paymentId, String employeeId, String date, String salary, String paymentMethod) {
        setPaymentId(paymentId);
        setEmployeeId(employeeId);
        this.date = date;
        this.setSalary(salary);
        setPaymentMethod(paymentMethod);
    }

    public EmployeePayment() {
    }

    public String getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(String paymentId) {
        PaymentId = paymentId;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "EmployeePayment{" +
                "PaymentId='" + PaymentId + '\'' +
                ", EmployeeId='" + EmployeeId + '\'' +
                ", date='" + date + '\'' +
                ", salary='" + salary + '\'' +
                ", PaymentMethod='" + PaymentMethod + '\'' +
                '}';
    }
}
