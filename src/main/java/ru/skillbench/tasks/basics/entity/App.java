package ru.skillbench.tasks.basics.entity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employee Chif = new EmployeeImpl();
        Chif.setFirstName("Ivan");
        Chif.setLastName("Ivanych");
        Chif.increaseSalary(3000);
        System.out.println( Chif );

        Employee SuperVizer = new EmployeeImpl();
        SuperVizer.setFirstName("Kirril");
        SuperVizer.setLastName("Kirrilov");
        SuperVizer.increaseSalary(2000);
        SuperVizer.setManager( (Employee) Chif );
        System.out.println( SuperVizer );

        Employee manager = new EmployeeImpl();
        manager.setFirstName("Misha");
        manager.setLastName("Braun");
        manager.increaseSalary(1000);
        manager.setManager( (Employee) SuperVizer );
        System.out.println( manager );

        //System.out.println(Chif.getTopManager());
        //System.out.println(manager.getTopManager());
    }
}
