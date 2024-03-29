package ru.skillbench.tasks.basics.entity;

/**
 * ЦЕЛЬ ЗАДАЧИ - применить понимание основ объектно-ориентированного программирования в Java,
 * принципы написания класса, реализации методов get/set, обращения к полям и методам объектов.
 *
 * ЗАДАНИЕ:
 * Реализовать класс, представляющий собой описание сотрудника компании (Employee).
 *
 * ТРЕБОВАНИЯ:
 * 1) Экземпляр класса, реализующего данный интерфейс, должен соответствовать одному сотруднику.
 * 2) Необходимо реализовать методы get/set для имени (и фамилии), полного имени, зарплаты сотрудника,
 *  а также его непосредственного менеджера и топового (самого вышестоящего) менеджера.
 * Данные (поля) должны быть объявлены как private-переменные класса.
 * Методы get** / set** должны оперировать с этими полями.
 * 3) По умолчанию (у только что созданного сотрудника) зарплата должна быть равна 1000.
 *
 * ОБЩИЕ ТРЕБОВАНИЯ (ко всем решениям задач для их автоматической проверки):
 * Вот как должна выглядеть реализация данного интерфейса:
 * public class EmployeeImpl implements Employee {  }
 * Если в коде есть конструкторы, то среди них должен быть конструктор без параметров:
 * public EmployeeImpl() {  }
 *
 * ПРИМЕЧАНИЕ:
 * Задачу можно решать без явной обработки и генерации исключительных ситуаций (Exceptions).
 *
 * @author Alexey Evdokimov
 * @author Alexander Kharichkin
 */
public class EmployeeImpl implements Employee {
    private int Salary;
    private String FirstName;
    private String LastName;
    private Employee manager;

    public EmployeeImpl(){
        this.Salary = 1000;
    }

    /**
     * @return Зарплата сотрудника на настоящий момент.
     */
    @Override
    public int getSalary() {
        return Salary;
    }

    /**
     * Увеличивает зарплату сотрудника на заданное значение
     * @param value Значение, на которое нужно увеличить
     */
    public void increaseSalary(int value) {
        Salary += value;
    }

    /**
     * @return Имя сотрудника
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Устанавливает имя сотрудника
     * @param firstName Новое имя
     */
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    /**
     * @return Фамилия сотрудника
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * Устанавливает фамилию сотрудника
     * @param lastName Новая фамилия
     */
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * @return Имя и затем фамилия сотрудника, разделенные символом " " (пробел)
     */
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    /**
     * Устанавливает Менеджера сотрудника.
     * @param manager Сотрудник, являющийся менеджером данного сотрудника.
     * НЕ следует предполагать, что менеджер является экземпляром класса EmployeeImpl.
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    /**
     * @return Имя и фамилия Менеджера, разделенные символом " " (пробел).
     * Если Менеджер не задан, возвращает строку "No manager".
     */
    public String getManagerName() {
        if (this.manager == null) {
            return "No manager";
        } else {
            return manager.getFullName();
        }

    }

    /**
     * Возвращает Менеджера верхнего уровня, т.е. вершину иерархии сотрудников,
     *   в которую входит данный сотрудник.
     * Если над данным сотрудником нет ни одного менеджера, возвращает данного сотрудника.
     * Замечание: поскольку менеджер, установленный методом {@link #setManager(Employee)},
     *   может быть экзепляром другого класса, при поиске топ-менеджера нельзя обращаться
     *   к полям класса EmployeeImpl. Более того, поскольку в интерфейсе Employee не объявлено
     *   метода getManager(), поиск топ-менеджера невозможно организовать в виде цикла.
     *   Вместо этого нужно использовать рекурсию (и это "более объектно-ориентированно").
     */
    public Employee getTopManager() {
        if ( this.manager == null) {
            return this;
        }
        return manager.getTopManager();
    }

    @Override
    public String toString() {
        //Employee oTopManager = getTopManager();
        //System.out.println(oTopManager);
        return "EmployeeImpl{" +
                "Salary=" + Salary +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FullName='" + getFullName() + '\'' +
                ", Manager=" + getManagerName() + '\'' +
                ", TopManager=" + getTopManager().getFullName() +
                '}';
    }
}