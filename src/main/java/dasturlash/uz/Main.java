package dasturlash.uz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        EmployeeEntity employee = new EmployeeEntity();
        employee.setName("Ali");
        employee.setSurname("Aliyev");
        employee.setPhone("12345678");

        session.save(employee);

        AddressEntity address = new AddressEntity();
        address.setCityName("Toshkent");
        address.setStreetName("Katta ko'chinskiy");
        address.setHomeNumber("27");
        address.setEmployee(employee);
        session.save(address);

        t.commit();

        factory.close();
        session.close();
    }
}