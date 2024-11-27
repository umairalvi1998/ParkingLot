package parkingLot.Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {

    Ticket ticket;
    Gate gate;
    BillStatus status;
    Integer amount;
    List<Payment> payments;
    Date exiTime;
    FeesCalculationStrategyType feeCalculationStrategyType;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate  gate) {
        this.gate = gate;
    }

    public FeesCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }


    public Date getExiTime() {
        return exiTime;
    }

    public void setExiTime(Date exiTime) {
        this.exiTime = exiTime;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
