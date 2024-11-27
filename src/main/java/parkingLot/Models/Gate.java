package parkingLot.Models;

public class Gate extends BaseModel{
    Operator operator;
    GateType gateType;
    GateStatus gateStatus;
    private  String gateNumber;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
