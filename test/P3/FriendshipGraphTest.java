package P3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FriendshipGraphTest {

    @Test public void testAddVertex() {
        FriendshipGraph graph = new FriendshipGraph();
        Person person = new Person("Person");
        graph.addVertex(person);//�жϼ����˶���
        assertTrue(graph.Allperson.contains(person));
        graph.addVertex(person);//�ж�û���ظ�����һ������Ķ���
        assertTrue(graph.Allperson.lastIndexOf(person)==graph.Allperson.indexOf(person));
    }

    @Test public void testAddEdge() {
        Person person1 = new Person("Person1");
        Person person2 = new Person("Person2");
        Person person3 = new Person("Person3");
        person1.addRelation(person2);
        assertTrue(person1.getRelation().contains(person2));
        assertFalse(person1.getRelation().contains(person3));
    }

    @Test public void testGetDistance() {
        FriendshipGraph graph = new FriendshipGraph();
        Person A = new Person("a");
        Person B = new Person("b");
        Person C = new Person("c");
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addEdge(A, B);
        graph.addEdge(B, A);
        graph.addEdge(B, C);
        graph.addEdge(C, B);
        graph.addEdge(A, C);
        graph.addEdge(C, A);
        //��֤�ҵ�����Ϊ��С
        assertEquals(1, graph.getDistance(A, C));
        
        Person D = new Person("d");
        graph.addVertex(D);
        graph.addEdge(C, D);
        graph.addEdge(D, C);
        graph.addEdge(B, D);
        graph.addEdge(D, B);
        graph.addEdge(A, D);
        graph.addEdge(D, A);
        //��֤�ҵ�����Ϊ��С
        assertEquals(1, graph.getDistance(A, D));
        
        //��֤�Լ����Լ��ľ���Ϊ0
        assertEquals(0, graph.getDistance(A, A));
        
        Person E = new Person("e");
        graph.addVertex(E);
        
        //��֤û�й�ϵ����-1
        assertEquals(-1, graph.getDistance(A, E));
    }

}
