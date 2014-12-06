package DecisionTree;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import DecisionTreeImpl.EntityImpl;
import DecisionTreeImpl.FactorImpl;
import DecisionTreeImpl.Node;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 06.03.14
 */

public class DecisionTreeImplTest {

    private enum Accs {Light, Standart, Premium}

    Node<Accs> subscrLight1 = new Node<>(Accs.Light);
    Node<Accs> subscrStandart1 = new Node<>(Accs.Standart);
    Node<Accs> subscrStandart2 = new Node<>(Accs.Standart);
    Node<Accs> subscrLight2 = new Node<>(Accs.Light);
    Node<Accs> subscrPremium = new Node<>(Accs.Premium);
    Node<Accs> conditionUserFromRus = new Node<>(subscrLight2, subscrStandart2, new FactorImpl("User from", "RUS"));
    Node<Accs> conditionLookedPage1 = new Node<>(subscrStandart1, subscrLight1, new FactorImpl("Looked page", ">10"));
    Node<Accs> conditionLookedPage2 = new Node<>(subscrPremium, conditionUserFromRus, new FactorImpl("Looked page", ">10"));
    Node<Accs> root = new Node<>(conditionLookedPage2, conditionLookedPage1, new FactorImpl("Came from", "google"));

    /**
     * <pre>
     * Came from google?
     *     F:Looked page >10?
     *         F:Light
     *         T:Standart
     *     T:Looked page >10?
     *         F:User from RUS?
     *             F:Standart
     *             T:Light
     *         T:Premium
     * </pre>
     */
    DecisionTreeImpl<Accs> tree = new DecisionTreeImpl<>(root);

    /**
     * This test checks that getCategory() method is working correctly with particular coditions.
     */
    @Test
    public void testGetCategory1() {
        EntityImpl premium = new EntityImpl(ImmutableMap.of(
                "Looked page", ">10",
                "Came from", "google",
                "User from", "USA"));
        assertEquals(Accs.Premium, tree.getCategory(premium));
    }

    /**
     * This test checks that getCategory() method is working correctly with particular coditions.
     */
    @Test
    public void testGetCategory2() {
        EntityImpl light = new EntityImpl(ImmutableMap.of(
                "Looked page", "<10",
                "Came from", "google",
                "User from", "RUS"));
        assertEquals(Accs.Light, tree.getCategory(light));
    }

    /**
     * This test checks that getCategory() method is working correctly with particular coditions.
     */
    @Test
    public void testGetCategory3() {
        EntityImpl standart = new EntityImpl(ImmutableMap.of(
                "Looked page", ">10",
                "Came from", "yandex",
                "User from", "UKR"));
        assertEquals(Accs.Standart, tree.getCategory(standart));
    }

    /**
     * This test checks that entity data is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyEntity() {
        HashMap<String, String> standartAtributes = new HashMap<>();
        EntityImpl standart = new EntityImpl(standartAtributes);
        tree.getCategory(standart);
    }

    /**
     * This test checks that name field is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyNameField() {
        new Node<Accs>(conditionLookedPage2, conditionLookedPage1, new FactorImpl("", "Value"));
    }

    /**
     * This test checks that value field is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyValueField() {
        new Node<Accs>(conditionLookedPage2, conditionLookedPage1, new FactorImpl("Name", ""));
    }

    /**
     * This test checks that node has children.
     */
    @Test(expected = NullPointerException.class)
    public void testNodeHasChild() {
        new Node<Accs>(null, null, new FactorImpl("Name", "Value"));
    }

    /**
     * This test checks that factor is not null.
     */
    @Test(expected = NullPointerException.class)
    public void testFactorIsNotNull() {
        new Node<Accs>(conditionLookedPage2, conditionLookedPage1, null);
    }

    /**
     * This test checks that result category is not null.
     */
    @Test(expected = NullPointerException.class)
    public void testCategoryIsNotNull() {
        new Node<Accs>(null);
    }

    /**
     * This test checks that root node is not null.
     */
    @Test(expected = NullPointerException.class)
    public void testRootIsNotNull() {
        new DecisionTreeImpl<Accs>(null);
    }

    /**
     * This test checks situation when tree is a root node. Test compares representation
     * of node and representation of tree (as root node).
     */
    @Test
    public void testTreeIsRoot() {
        Node<Accs> testRoot = new Node<>(Accs.Premium);
        DecisionTreeImpl<Accs> testTree = new DecisionTreeImpl<>(testRoot);
        assertEquals(testRoot.toString() + "\n", testTree.toString());
    }

    /**
     * This test checks that toString() method is working correctly.
     */
    @Test
    public void testToString() {
        String expected =
                "Came from google?\n" +
                "    F:Looked page >10?\n" +
                "        F:Light\n" +
                "        T:Standart\n" +
                "    T:Looked page >10?\n" +
                "        F:User from RUS?\n" +
                "            F:Standart\n" +
                "            T:Light\n" +
                "        T:Premium\n";
        assertEquals(expected, tree.toString());
        System.out.println("Test toString():\n" + "----------------------");
        System.out.print(tree.toString());
        System.out.println("----------------------\n");
    }

    /**
     * This test checks that toString() method is working correctly when tree contains three nodes.
     */
    @Test
    public void testToStringWhenTreeIsThreeNode() {
        Node<Accs> testSubscrLight = new Node<>(Accs.Light);
        Node<Accs> testSubscrPremium = new Node<>(Accs.Premium);
        Node<Accs> testRoot = new Node<>(testSubscrPremium, testSubscrLight, new FactorImpl("Came from", "google"));
        DecisionTreeImpl<Accs> testTree = new DecisionTreeImpl<>(testRoot);

        String expected =
                "Came from google?\n" +
                "    F:Light\n" +
                "    T:Premium\n";
        assertEquals(expected, testTree.toString());
        System.out.println("Test toString() when tree contains three nodes:\n" + "----------------------");
        System.out.print(testTree.toString());
        System.out.println("----------------------\n");
    }
}
