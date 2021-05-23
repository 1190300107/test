package P3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FriendshipGraph {

    public void addVertex(Person person) {// ��Ӷ���
        if (!Allperson.contains(person)) {
            Allperson.add(person);
            if (nameCheck.get(person.getName()) == null) {
                nameCheck.put(person.getName(), person);
            } else {
                System.out.println("Each person should has an unique name!");
                System.exit(0);
            }
        } else {
            System.out.println("�����Ѿ�������");
        }
    }

    public void addEdge(Person person1, Person person2) {// ��ӹ�ϵ��
        person1.addRelation(person2);
    }

    public int getDistance(Person person1, Person person2) {// �õ����˾���
        if (person1 == person2) {// ��ͬһ���ˣ�����0
            return 0;
        }
        Map<Person, Boolean> visited = new HashMap<>();// �����ж��Ƿ񱻷���
        Map<Person, Integer> dis = new HashMap<>();// ���ڼ�¼����
        for (Person temp : Allperson) {// ������person���Ϊδ������
            visited.put(temp, false);
        }
        visited.put(person1, true);
        dis.put(person1, 0);
        Queue<Person> queue = new LinkedBlockingQueue<>();// �ȹ�Ҫ�ö�������
        queue.add(person1);// person1���
        while (!queue.isEmpty()) {// ѭ��ֱ������Ϊ��
            Person head = queue.poll();// �õ�����Ԫ�أ����������
            Person temp = head.getRelation().peek();// �õ������йصĵ�һ����
            int i = 0;
            while (temp != null) {// ѭ��ֱ��������head��ֱ�ӹ�ϵ
                if (!visited.get(temp)) {// ��tempδ������
                    if (temp.equals(person2)) {// ���ҵ�person2
                        return dis.get(head) + 1;
                    } else {// ��δ�ҵ�
                        visited.put(temp, true);
                        dis.put(temp, dis.get(head) + 1);
                        queue.add(temp);// ����ǰperson���
                    }
                }
                if (++i < head.getRelation().size()) {// ����Ѱ�������й�ϵ����
                    temp = head.getRelation().get(i);
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public ArrayList<Person> Allperson = new ArrayList<>();// ���ڴ������е�person
    Map<String, Person> nameCheck = new HashMap<>();

    public static void main(String[] args) {

        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);
         graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);
        System.out.println(graph.getDistance(rachel, ross));
        // should print 1
        System.out.println(graph.getDistance(rachel, ben));
        // should print 2
        System.out.println(graph.getDistance(rachel, rachel));
        // should print 0
        System.out.println(graph.getDistance(rachel, kramer));
        // should print -1
    }
}
