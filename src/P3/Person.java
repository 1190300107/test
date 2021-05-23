package P3;

import java.util.LinkedList;

public class Person {

    private String name;
    private LinkedList<Person> connect = new LinkedList<>();// ��person��ֱ�ӹ�ϵ����

    public Person(String name) {
        this.name = name;// person����
    }

    public void addRelation(Person person) {
        this.connect.add(person);// �õ�person��ϵ
    }

    public String getName() {
        return this.name;// �õ�person����
    }

    public LinkedList<Person> getRelation() {
        return this.connect;// �õ���֮�й�ϵ����
    }
}
