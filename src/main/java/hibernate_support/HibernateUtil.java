package hibernate_support;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.ConstraintViolationException;


import javax.persistence.PersistenceException;


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    static {
        System.out.println("HibernateSupport: Constructor");
        getSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) try {
            // Create registry
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    private static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void beginTransaction() {getCurrentSession().beginTransaction(); }

    public static void commitTransaction() {getCurrentSession().getTransaction().commit();}

    public static boolean commit(Object obj) {
        try { getCurrentSession().saveOrUpdate(obj);}
        catch (HibernateException e) { return false; }
        return true;
    }

    public static <T> void deleteObject(Object obj){getCurrentSession().delete(obj);}

    public static String useNativeQuery(String query){
        return (String) getCurrentSession().createNativeQuery(query).getSingleResult();
    }
}