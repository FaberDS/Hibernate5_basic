package hibernate_support;


import bsd18.schuele.data.RegisteredUser;
import bsd18.schuele.data.User;


public class MainApp {
    public static void main(String[] args) {
        HibernateUtil.beginTransaction();

        String sql = "select version()";
        String result = HibernateUtil.useNativeQuery(sql);
        HibernateUtil.commitTransaction();
        System.out.println(result);


        User user= new User("David");
        RegisteredUser regUser = new RegisteredUser("bubu","pwd", "bubu@gmx.at");
        RegisteredUser regUser2 = new RegisteredUser("bubu","pwd", "bubu@gmx.at", true);

        HibernateUtil.beginTransaction();
        System.out.println(user.saveDB());
        HibernateUtil.commitTransaction();
        HibernateUtil.beginTransaction();
        System.out.println(regUser.saveDB());
        HibernateUtil.commitTransaction();
        HibernateUtil.beginTransaction();
        System.out.println(regUser2.saveDB());
        HibernateUtil.commitTransaction();

        HibernateUtil.shutdown();
    }
}