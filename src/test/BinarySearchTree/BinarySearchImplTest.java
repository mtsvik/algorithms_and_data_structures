package BinarySearchTree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 20.11.13
 */

public class BinarySearchImplTest {
    @Test
    public void testFind() {
        BinarySearchTreeImpl<Integer, String> tree = new BinarySearchTreeImpl<>();
        tree.insert(3, "a");
        tree.insert(8, "a");
        tree.insert(5, "B");
        tree.insert(9, "z");
        assertEquals(tree.find(5).getValue(), "B");
        assertEquals(tree.find(99), null);
    }

    @Test
    public void testRemove() {
        BinarySearchTreeImpl<Integer, String> tree = new BinarySearchTreeImpl<>();
        tree.insert(3, "a");
        tree.insert(8, "a");
        tree.insert(5, "B");
        tree.insert(9, "z");
        tree.remove(5);
        assertEquals(null, tree.find(5));
        try {
            tree.remove(5);
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testGetOrderedNodes() {
        BinarySearchTreeImpl<Integer, String> tree = new BinarySearchTreeImpl<>();
        tree.insert(3, "a");
        tree.insert(8, "a");
        tree.insert(5, "B");
        tree.insert(9, "z");
        List<BinarySearchTree.Node<Integer, String>> list = tree.getOrderedNodes();
        assertEquals((Object) 3, list.get(0).getKey());
        assertEquals((Object) 5, list.get(1).getKey());
        assertEquals((Object) 8, list.get(2).getKey());
        assertEquals((Object) 9, list.get(3).getKey());
    }

}
