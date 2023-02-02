package lk.ijse.TeddyHouse.to;

public class Lending {
    private String CustomerId;
    private String NIC;
    private String Date;
    private String LoanAmount;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Lending(String customerId, String NIC, String date, String loanAmount) {
        setCustomerId(customerId);
        this.setNIC(NIC);
        Date = date;
        setLoanAmount(loanAmount);
    }

    public Lending() {
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        LoanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Lending{" +
                "CustomerId='" + CustomerId + '\'' +
                ", NIC='" + NIC + '\'' +
                ", Date='" + Date + '\'' +
                ", LoanAmount='" + LoanAmount + '\'' +
                '}';
    }
}
