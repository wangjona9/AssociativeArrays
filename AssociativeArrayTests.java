import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * Tests of the AssociativeArray class.
 *
 * @author CSC-207 2023Fa
 */
public class AssociativeArrayTests {

  // +---------------------+-----------------------------------------
  // | Tests by Sam Bigham |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Micah Cantor |
  // +-----------------------+
  
  /**
   * Micah says Let's test out Hoare's billion dollar mistake. Sam, I hope these tests are right.
   * 
   * Sam says null shouldn't be a value.
   */
  public void micahCantorTest1() {
    // values may be null
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("NULL", null);
    assertEquals("{ NULL: null }", arr.toString());
    try {
      assertEquals(null, arr.get("NULL"));
    } catch (Exception e) {
      fail("Should not throw an exception when accessing null value");
    }
    arr.set("NULL", "null"); // Don't crash here!
  }

  /**
   * SamR removed this test because null need not be a valid key.
   * (It wasn't specified.)
   */
  public void micahCantorTest2() {
    // keys and values may be null
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set(null, null);
    assertEquals("{ null: null }", arr.toString());
    try {
      assertEquals(null, arr.get(null)); // Why not?
      arr.set(null, "not null"); // don't crash here either
    } catch (Exception e) {
      fail("Should not crash when getting/setting null key.");
    }
  }

  /**
   * Micah remains evil.
   *
   * SamR removed this test because the behavior on null inputs
   * is unspecified.
   */
  public void micahCantorEdge1() {
    // Uh oh.
    AssociativeArray<Object, Object> arr = new AssociativeArray<Object, Object>();
    Object value = new Object();
    arr.set(null, value);
    assertEquals("{ null: " + value.toString() + " }", arr.toString());
    arr.set(value, null);
    try {
      assertEquals(null, arr.get(value));
    } catch (Exception e) {
      fail("Should not crash when accessing Object key with null value.");
    }

    // Make sure removal doesn't break with null values
    Object value2 = new Object();
    arr.set(value2, null);
    arr.remove(value);
    arr.remove(null); // Should remove the pair (null, value)
    arr.remove(null); // Should do nothing
    try {
      assertEquals(null, arr.get(value2));
    } catch (Exception e) {
      fail("Should not crash when accessing Object key with null value after removing other keys.");
    }
  }


  // +------------------------+--------------------------------------
  // | Tests by Reed Colloton |
  // +------------------------+

  // +------------------+--------------------------------------------
  // | Tests by Pom Dao |
  // +------------------+

  // +--------------------------+------------------------------------
  // | Tests by Joshua Delarosa |
  // +--------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Jinny Eo |
  // +-------------------+

  // +---------------------------+-----------------------------------
  // | Tests by Kevin Fitzgerald |
  // +---------------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Joyce Gill |
  // +---------------------+

  // +--------------------+------------------------------------------
  // | Tests by Che Glenn |
  // +--------------------+

  // +-------------------------+-------------------------------------
  // | Tests by Kevin Johanson |
  // +-------------------------+

  // +----------------------+----------------------------------------
  // | Tests by Chloe Kelly |
  // +----------------------+

  /**
   * Does toString() skip all empty values?
   *
   * SamR removed this test because it makes assumptions about the
   * order of values in the array.
   */
  public void chloeKellyTest1() {
    // Build Array
    AssociativeArray<String, String> testarr = new AssociativeArray<String, String>();
    // Set some values
    testarr.set("A", "Red");
    testarr.set("B", "Blue");
    testarr.set("C", "Green");
    try {
      assertEquals("Red", testarr.get("A"));
    } catch (Exception e) {
      fail("Array value could not be set to Red");
    } // try/catch Red
    try {
      assertEquals("Blue", testarr.get("B"));
    } catch (Exception e) {
      fail("Array value could not be set to Blue");
    } // try/catch Blue
    try {
      assertEquals("Green", testarr.get("C"));
    } catch (Exception e) {
      fail("Array value could not be set to Green");
    } // try/catch green

    assertEquals("{ A: Red, B: Blue, C: Green }", testarr.toString());
    // Remove the middle value
    testarr.remove("B");
    assertEquals("{ A: Red, C: Green }", testarr.toString());
  }// chloeKellyTest1()

  /**
   * Replace values at a given key
   */
  @Test
  public void chloeKellyTest2() {
    AssociativeArray<String, String> testarr = new AssociativeArray<String, String>();
    // Set the value
    testarr.set("A", "Red");
    try {
      assertEquals("Red", testarr.get("A"));
    } catch (Exception e) {
      fail("Array value could not be set to Red");
    } // try/catch Red
    // Replace the value
    testarr.set("A", "Yellow");
    // Check if it worked
    try {
      assertEquals("Yellow", testarr.get("A"));
    } catch (Exception e) {
      fail("Array value could not be set to Yellow");
    } // try/catch Red
  }// chloeKellyTest2()

  /**
   * Printing an empty array
   */
  @Test
  public void chloeKellyEdge1() {
    AssociativeArray<String, String> testarr = new AssociativeArray<String, String>();
    // Make sure it is empty
    assertEquals(0, testarr.size());
    assertEquals("{}", testarr.toString());
  }// chloeKellyEdge1()

  // +--------------------+------------------------------------------
  // | Tests by Hyeon Kim |
  // +--------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Julian Kim |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Jason Kunkel |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Wenfei Lin |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Noah Mendola |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by John Miller |
  // +----------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Albert Okine |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Alma Ordaz |
  // +---------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Samuel A. Rebelsky |
  // +-----------------------------+

  /**
   * A test of cloning.
   */
  @Test
  public void samuelRebelskyTest01() {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (Exception e) {
      fail("Original array does not contain expected value");
    }
    // Make a copy
    AssociativeArray<String, String> arr2 = arr.clone();
    // Make sure it contains the appropriate value
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Clone does not contain original value");
    } // try/catch
    // Change the original array
    arr.set("A", "aardvark");
    // Make sure we haven't changed the clone.
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Change to original changes clone.");
    }
    // Change the clone
    arr2.set("A", "Ant");
    // And look for values
    try {
      assertEquals("Ant", arr2.get("A"));
    } catch (Exception e) {
      fail("Cannot change clone");
    }
    try {
      assertEquals("aardvark", arr.get("A"));
    } catch (Exception e) {
      fail("Change to clone changes original");
    }
  } // samuelRebelskyTest01()

  /**
   * Can we successfully add a bunch of values? (Checks array expansion.)
   */
  @Test
  public void samuelRebelskyTest02() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 10; i < 50; i++) {
      arr.set(i, i * i);
    } // for
    try {
      for (int i = 49; i >= 10; i--) {
        assertEquals(i * i, arr.get(i));
      }
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // samuelRebelskyTest02()

  /**
   * Do we get exceptions when grabbing a deleted value from the array?
   */
  @Test
  public void samuelRebelskyTest03() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("A", "Apple");
    // Make sure that it's there.
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (KeyNotFoundException e) {
      fail("Could not set A to Apple");
    }
    // Remove it.
    arr.remove("A");
    // Make sure it's no longer there.
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyTest03

  /**
   * Do we get exceptions when grabbing a value from the empty array.
   */
  @Test
  public void samuelRebelskyEdge01() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyEdge01

  // +--------------------------+------------------------------------
  // | Tests by Maria Rodriguez |
  // +--------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Gabriela Roznawska |
  // +-----------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Shuta Shibue |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by Madel Sibal |
  // +----------------------+

  // +------------------------------+--------------------------------
  // | Tests by Livia Stein Freitas |
  // +------------------------------+

  // +------------------------+--------------------------------------
  // | Tests by Tyrell Taylor |
  // +------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Audrey Trinh |
  // +-----------------------+

  // +-------------------------+-----------------------------------------
  // | Tests by Rene Urias Jr. |
  // +-------------------------+

  /**
   * Test basic functionality of setting and getting values
   */
  @Test
  public void reneUriasTest01() {
    AssociativeArray<Integer, String> arr = new AssociativeArray<Integer, String>();
    arr.set(1, "One");
    arr.set(2, "Two");
    arr.set(3, "Three");

    try {
      assertEquals("One", arr.get(1));
      assertEquals("Two", arr.get(2));
      assertEquals("Three", arr.get(3));
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // reneUriasTest01

  /**
   * Test array expansion and size calculation
   */
  @Test
  public void reneUriasTest02() {
    AssociativeArray<String, Integer> arr = new AssociativeArray<String, Integer>();

    // Add values to trigger expansion
    for (int i = 1; i <= 30; i++) {
      arr.set("Key" + i, i);
    }

    assertEquals(30, arr.size());

    try {
      for (int i = 1; i <= 30; i++) {
        assertEquals(i, (int) arr.get("Key" + i));
      }
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // reneUriasTest02

  /**
   * Test removing a key and ensue it throws KeyNotFoundException on retrieval
   */
  @Test
  public void reneUriasTest03() {
    AssociativeArray<String, Double> arr = new AssociativeArray<String, Double>();
    arr.set("Pi", 3.14);

    try {
      assertEquals(3.14, arr.get("Pi"), 0.001);
    } catch (Exception e) {
      fail("Exception in call to get");
    }

    arr.remove("Pi");

    try {
      // The following line should throw KeyNotFoundException
      arr.get("Pi");
      fail("Did not throw KeyNotFoundException");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // reneUriasTest03

  /**
   * Test setting and getting values in the associative array
   */
  @Test
  public void reneUriasTestSetAndGet() {
    AssociativeArray<String, Integer> array = new AssociativeArray<>();

    array.set("one", 1);
    array.set("two", 2);
    array.set("three", 3);

    try {
      assertEquals(1, array.get("one"));
      assertEquals(2, array.get("two"));
      assertEquals(3, array.get("three"));
    } catch (KeyNotFoundException e) {
      fail("Unexpected KeyNotFoundException: " + e.getMessage());
    }
  } // reneUriasTestSetAndGet

  /**
   * Test setting values and overriding existing values in the associative array
   */
  @Test
  public void reneUriasTestSetOverride() {
    AssociativeArray<String, String> array = new AssociativeArray<>();

    array.set("color", "red");

    try {
      assertEquals("red", array.get("color"));

      array.set("color", "blue"); // Overriding value for key "color"

      assertEquals("blue", array.get("color"));
    } catch (KeyNotFoundException e) {
      fail("Unexpected KeyNotFoundException: " + e.getMessage());
    }
  } // reneUriasTestSetOverride

  /**
   * Test checking if a key exists in the associative array
   */
  @Test
  public void reneUriasTestHasKey() {
    AssociativeArray<Character, Double> array = new AssociativeArray<>();

    array.set('A', 4.0);
    array.set('B', 3.5);

    assertTrue(array.hasKey('A'));
    assertTrue(array.hasKey('B'));
    assertFalse(array.hasKey('C')); // Key 'C' does not exists
  } // reneUriasTestHasKey

  /**
   * Test removing entires from the associative array
   */
  @Test
  public void reneUriasTestRemove() {
    AssociativeArray<Integer, String> array = new AssociativeArray<>();
    array.set(1, "one");
    array.set(2, "two");
    array.set(3, "three");

    array.remove(2); // Removing entry with key 2

    assertFalse(array.hasKey(2)); // Key 2 should not exists after removal
    assertEquals(2, array.size()); // Size should be reduced to 2
  } // reneUriasTestRemove

  /**
   * Test checking the size of the associative array
   */
  @Test
  public void reneUriasTestSize() {
    AssociativeArray<String, Boolean> array = new AssociativeArray<>();

    assertEquals(0, array.size()); // Initial size should be 0

    array.set("true", true);
    array.set("false", false);

    assertEquals(2, array.size()); // After adding two entries

    array.remove("true");

    assertEquals(1, array.size()); // After removing one entry
  } // reneUriasTestSize

  /**
   * Test converting the associative array to a string representation
   *
   * SamR removed this test because it makes assumptions about the
   * ordering of values in the array.
   */
  public void reneUriasTestToString() {
    AssociativeArray<String, Integer> array = new AssociativeArray<>();
    array.set("apple", 5);
    array.set("banana", 3);
    array.set("cherry", 8);

    String expected = "{ apple: 5, banana: 3, cherry: 8 }";

    assertEquals(expected, array.toString());
  } // reneUriasTestToString

  /**
   * Test handling KeyNotFoundException when trying to get a non-existent key
   */
  @Test
  public void reneUriasTestKeyNotFoundException() {
    AssociativeArray<String, Double> array = new AssociativeArray<>();
    array.set("pi", 3.14);

    assertThrows(KeyNotFoundException.class, () -> array.get("e")); // Key 'e' does not exist
  } // reneUriasTestKeyNotFoundExceptions

  // +-----------------------+---------------------------------------
  // | Tests by Christina Vu |
  // +-----------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Luke Walters |
  // +-----------------------+

  // +------------------------+--------------------------------------
  // | Tests by Jonathan Wang |
  // +------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Lydia Ye |
  // +-------------------+

} // class AssociativeArrayTests