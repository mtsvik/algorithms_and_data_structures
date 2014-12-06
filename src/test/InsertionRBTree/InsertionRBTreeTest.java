package InsertionRBTree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mtsvik
 * Date: 20.11.13
 */
public class InsertionRBTreeTest {
    @Test
    public void testTree() {
        InsertionRBTree<Integer, String> tree = new InsertionRBTree();
        tree.insert(34, "a");
        tree.insert(8, "b");
        tree.insert(45, "c");
        tree.insert(-13, "d");
        tree.insert(0, "");
        InsertionRBTree.NodeImpl y = tree.getRoot();
        assertEquals(y.getColor(), InsertionRBTree.Color.BLACK);
        Queue<InsertionRBTree.NodeImpl> queue = new LinkedList<>();
        queue.offer(tree.getRoot());
        while(!queue.isEmpty()) {
            InsertionRBTree.NodeImpl x = queue.poll();
            if (x.getColor() == InsertionRBTree.Color.BLACK || x.getColor() == InsertionRBTree.Color.RED) {
                if (x.getColor() == InsertionRBTree.Color.RED) {
                    if (x.left != null) {
                        queue.offer(x.left);
                        if (x.left.getColor() != InsertionRBTree.Color.BLACK) {
                            fail("Color of child is red, node isn't black");
                        }
                    }
                    if (x.right != null) {
                        queue.offer(x.right);
                        if (x.right.getColor() != InsertionRBTree.Color.BLACK) {
                            fail("Color of child is red, node isn't black");
                        }
                    }
                }
            } else {
                fail("Color isn't red or black");
            }
        }
    }
}