import java.io.Serializable;

public class CallDetailRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private int fromNumber;
    private int toNumber;
    private float duration;
    private float charge;

    public CallDetailRecord(int fromNumber, int toNumber, float duration, float charge) {
        this.fromNumber = fromNumber;
        this.toNumber = toNumber;
        this.duration = duration;
        this.charge = charge;
    }

    public int getFromNumber() {
        return fromNumber;
    }

    public int getToNumber() {
        return toNumber;
    }

    public float getCharge() {
        return charge;
    }
}



