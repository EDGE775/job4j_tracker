package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь с таким именем не найден!");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isvalid() && user.getUsername().length() >= 3) {
            return true;
        }
        throw new UserInvalidException("Пользователь невалиден!");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Khlapov Dmitry", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException ne) {
            ne.printStackTrace();
        }
    }
}
