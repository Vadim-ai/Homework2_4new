package work;

import static work.Validator.getResultOfValidate;

public class Main {

    public static void main(String[] args) {

    AuthorizationParam user1 = new AuthorizationParam("Michel27", "Pixar24_7","Pixar24_7");
        System.out.println(getResultOfValidate(user1));
    }
}