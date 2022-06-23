package work;

public class Validator {

    private static void validateUserAccount (AuthorizationParam user)  throws Throwable{

        if (user.getLogin().length() >= 20) {
            throw new WrongLoginException("Wrong login length");
        }
        if (user.getPassword().length() > 20 || user.getPassword().length() < 6 ) {
            throw new WrongPasswordException("Wrong password length");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new WrongPasswordException("Some mistake in password, try again");
        }

        String validChar = "0123456789_QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm";

        for (char ch:user.getLogin().toCharArray()) {
            boolean contains = validChar.contains(String.valueOf(ch));
            System.out.println("char: " + ch + " contains: " + contains);
            if(!contains){
                throw new WrongLoginException("Wrong char on Login");
            }
        }

        for (char ch:user.getPassword().toCharArray()) {
            boolean contains = validChar.contains(String.valueOf(ch));
            System.out.println("char: " + ch + " contains: " + contains);
            if(!contains){
                throw new WrongPasswordException("Wrong char on password");
            }
        }
    }
    public static boolean getResultOfValidate (AuthorizationParam user){
        try {
            validateUserAccount(user);
            return true;
        } catch (WrongLoginException e) {
            System.out.println("Поймали баг с логином" + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Поймали баг с паролем" + e.getMessage());
            return false;
        } catch (Throwable e) {
            return false;
        }
    }
}
