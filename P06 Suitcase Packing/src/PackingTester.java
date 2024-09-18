import java.util.ArrayList;

/**
 * Class used for testing the methods in the Packing class.
 */
public class PackingTester {
  /**
   * Tester method for the Packing.rushedPacking() method base cases.
   * It should test at least the following scenarios:
   * - There are no items left to pack in the suitcase
   * - There are items left to pack, but none of them fit
   * @return true if all tests pass, false otherwise
   */
  public static boolean rushedPackingBaseTest() {
    // TODO: Create test cases
    return false; // default return value
  }

  /**
   * Tester method for the Packing.rushedPacking() method recursive cases.
   * It should test at least the following scenarios:
   * - All the items remaining can fit in the suitcase
   * - At least one item remaining cannot fit in the suitcase
   * @return true if all tests pass, false otherwise
   */
  public static boolean rushedPackingRecursiveTest() {
    // TODO: Create test cases
    return false; // default return value
  }

  /**
   * Tester method for the Packing.greedyPacking() method base cases.
   * It should test at least the following scenarios:
   * - There are no items left to pack in the suitcase
   * - There are items left to pack, but none of them fit
   * @return true if all tests pass, false otherwise
   */
  public static boolean greedyPackingBaseTest() {
    //There are no items left to pack in the suitcase
    ArrayList<Item> items1 = new ArrayList<Item>();

    Suitcase suitcase1 = new Suitcase(12,12, items1);

    Suitcase actualSuitcase1 = Packing.greedyPacking(suitcase1);

    if (! actualSuitcase1.equals(suitcase1)) { //should not be contents in the suitcase
      return false;
    }

    //There are items left to pack but none of them fit
    ArrayList<Item> items2 = new ArrayList<Item>();

    //items too large for suitcase
    Item jacket = new Item("Jacket", 13, 8); //
    Item skis = new Item("Skis", 2, 14);

    items2.add(jacket);
    items2.add(skis);

    Suitcase suitcase2 = new Suitcase(12,12, items2);

    Suitcase actualSuitcase2 = Packing.greedyPacking(suitcase2);

    if (!actualSuitcase2.equals(suitcase2)) { //should not be contents in the suitcase
      return false;
    }
    return true; // default return value
  }

  /**
   * Tester method for the Packing.greedyPacking() method recursive cases.
   * It should test at least the following scenarios:
   * - At least one item is packed out of order (an item with a higher index
   *   is packed before an item with a lower index)
   * - A scenario where the greedy packing method packs more of the suitcase
   *   than the rushed packing (you can use the example given in the writeup)
   * @return true if all tests pass, false otherwise
   */
  public static boolean greedyPackingRecursiveTest() {
    // TODO: Create test cases
    return false; // default return value
  }

  /**
   * Tester method for the Packing.optimalPacking() method.
   * This tester should test the optimalPacking() method by
   * randomly generating at least TEN (10) different scenarios,
   * and randomly generating at least ONE-HUNDRED (100)
   * different packing solutions for EACH of the scenarios.
   * Each scenario should have at least FIVE (5) random items,
   * and the suitcases should be of size at least 5x5.
   * If any random solution is better than the optimal packing then
   * it is not actually optimal, so the method does not pass the test.
   * You should use the Utilities method to generate random lists of
   * items, and to randomly pack the suitcases.
   * @return true if all tests pass, false otherwise
   */
  public static boolean optimalPackingRandomTest() {
    // TODO: Create randomized test cases
    return false; // default return value
  }

  public static void main(String[] args) {
    boolean allPass = true;
    String printFormat = "%-29s %s\n";

    boolean rushedBase = rushedPackingBaseTest();
    allPass &= rushedBase;
    System.out.printf(printFormat, "rushedPackingBaseTest():", rushedBase);

    boolean rushedRecur = rushedPackingRecursiveTest();
    allPass &= rushedRecur;
    System.out.printf(printFormat, "rushedPackingRecursiveTest():", rushedRecur);

    boolean greedyBase = greedyPackingBaseTest();
    allPass &= greedyBase;
    System.out.printf(printFormat, "greedyPackingBaseTest():", greedyBase);

    boolean greedyRecur = greedyPackingRecursiveTest();
    allPass &= greedyRecur;
    System.out.printf(printFormat, "greedyPackingRecursiveTest():", greedyRecur);

    boolean optimalRandom = optimalPackingRandomTest();
    allPass &= optimalRandom;
    System.out.printf(printFormat, "optimalPackingRandomTest():", optimalRandom);

    System.out.printf(printFormat, "All tests:", allPass);
  }
}
