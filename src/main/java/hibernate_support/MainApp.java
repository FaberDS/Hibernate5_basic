package hibernate_support;


import bsd18.schuele.data.User;


public class MainApp {
    public static void main(String[] args) {
        HibernateUtil.beginTransaction();

        String sql = "select version()";
        String result = HibernateUtil.useNativeQuery(sql);
        HibernateUtil.commitTransaction();
        System.out.println(result);


        User user= new User("David");

        HibernateUtil.beginTransaction();
        System.out.println(user.saveDB());
        HibernateUtil.commitTransaction();

        HibernateUtil.shutdown();
    }
}