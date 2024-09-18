import java.util.ArrayList;

/**
 * Class used for packing a 2D suitcase with items using various strategies.
 */
public class Packing {
  /**
   * Tries to pack each item in the items list in-order.
   * If an item can fit, it must be packed. Otherwise, it should be skipped.
   * Must be a recursive method.
   *
   * @param suitcase current Suitcase object
   * @return a Suitcase representing the outcome of a strategy in which the items
   * were attempted to be packed in-order.
   */
  public static Suitcase rushedPacking(Suitcase suitcase) {
    // set packedItem to null, stores object already packed.
    Item packedItem = null;

    // list of items to be packed.
    ArrayList<Item> itemToPack = suitcase.getPackedItems();

    // find first item that is able to fit in the space of the suitcase.
    for (Item i : itemToPack) {
      if (suitcase.canPackItem(i)) {
        packedItem = i;
        break;
      }
    }
    // if there are no items that fit and are packed, return suitcase.
    // Otherwise, recursively run through the rest of the array.
    if (packedItem == null) {
      return suitcase;
    } else {
      suitcase = suitcase.packItem(packedItem);
      return rushedPacking(suitcase);
    }
  }

  /**
   * Packs items by greedily packing the largest item which can currently be packed.
   * Must be a recursive method.
   *
   * @param suitcase current Suitcase object
   * @return a Suitcase representing the outcome of a greedy strategy in which at each
   * point the largest item that can fit is packed.
   */
  public static Suitcase greedyPacking(Suitcase suitcase) {
    // set packedItem to null, stores object already packed.
    Item packedItem = null;

    // list of items to be packed.
    ArrayList<Item> itemToPack = suitcase.getPackedItems();

    // find the largest item that is able to fit in the space of the suitcase.
    packedItem = findMaxArea(itemToPack, suitcase);

    // if there are no items that fit and are packed, return suitcase.
    // Otherwise, recursively run through the rest of the array.
    if (packedItem == null) {
      return suitcase;
    } else {
      suitcase = suitcase.packItem(packedItem);
      return rushedPacking(suitcase);
    }
  }

  /**
   * Helper method to find the largest item in the ArrayList of items.
   *
   * @param itemToPack
   * @param suitcase
   * @return maxItem, the item with the largest area in the given array.
   */
  private static Item findMaxArea(ArrayList<Item> itemToPack, Suitcase suitcase) {
    // initialize max item to null.
    Item maxItem = null;
    // set maxArea to 0
    int maxArea = 0;

    // for the items in the ArrayList, compare the area with the max, and set maxItem to the
    // item in the array that has the largest area.
    for (Item i : itemToPack) {
      int itemArea = i.width * i.height;
      if ((maxArea < itemArea) && (suitcase.canPackItem(i))) {
        maxArea = itemArea;
        maxItem = i;
      }
    }

    return maxItem;
  }
}

//  /**
//   * Finds the optimal packing of items by trying all packing orders.
//   * Must be a recursive method.
//   *
//   * @param suitcase current Suitcase
//   * @return a Suitcase representing the optimal outcome.
//   */
//  public static Suitcase optimalPacking(Suitcase suitcase) {
//    // TODO: Implement this method recursively
//    // TODO: Add inline comments to explain your algorithm and recursive thinking
//    return null; // default return value
//  }
//}
