// 1. Activity class
public class Activity {
    private String string1;
    private String string2;
    private String operator;

    // Default constructor
    public Activity() {}

    // All-argument constructor
    public Activity(String string1, String string2, String operator) {
        this.string1 = string1;
        this.string2 = string2;
        this.operator = operator;
    }

    // Getter and Setter methods
    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

// 2. Custom exception OperatorException
class OperatorException extends Exception {
    public OperatorException(String message) {
        super(message);
    }
}

// 3. Source class
public class Source {
    public static void main(String args[]) {
        Activity activity = new Activity("Hello", "Welcome", "+");
        Source source = new Source();
        try {
            if (!source.validate(activity)) {
                throw new OperatorException("Invalid parameters");
            }

            String result = source.doOperation(activity);
            System.out.println(result);

        } catch (OperatorException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(Activity activity) throws OperatorException {
        if (activity.getString1() == null || activity.getString2() == null || activity.getOperator() == null) {
            throw new NullPointerException("One or more fields are null");
        }
        if (!activity.getOperator().equals("+") && !activity.getOperator().equals("-")) {
            throw new OperatorException("Invalid operator");
        }
        return true;
    }

    public String doOperation(Activity activity) {
        if (activity.getOperator().equals("+")) {
            return activity.getString1() + activity.getString2();
        } else if (activity.getOperator().equals("-")) {
            return activity.getString1().replace(activity.getString2(), "");
        }
        return null;
    }
}

