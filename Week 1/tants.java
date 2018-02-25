/**
  Erik kaljumäe veebr 2018
  Week 1
  Homework: Tantsupaarid v2 2018-02-18
  IN via CL: 
  3 176 179 169 2 172 167
  OUT in CL:
  176 ja 172
  169 ja 167
 */
// Import array package
import java.util.Arrays;

// Main class
class tants {
  public static void main(String[] args) {
    // Get numbers from args
    int[] nums = stringArrToInt(args);
    // Two height arrays
    int[] p = Arrays.copyOfRange(nums, 1, nums[0]+1);
    int[] t = Arrays.copyOfRange(nums, nums[0]+2, nums[0]+2 +nums[nums[0]+1] );

    // Create pairs
    int[][] pairs = combine(p, t);
    // Print pairs
    for (int pair = 0; pair<pairs.length; pair++) {
      System.out.println(pairs[0][pair] + " ja " + pairs[1][pair]);
    };
  }

  // parse String array into Integer array
  private static int[] stringArrToInt(String[] s) {
    int[] r = new int[s.length];
    for(int i=0; i<s.length; i++) {
      r[i] = Integer.parseInt(s[i]);
    }
    return r;
  }

  // Create pairs according to the criteria
  private static int[][] combine(int[] p, int[] t) {
    // Find shortest array, if possible
    int shortestLength = (p.length > t.length)?t.length:p.length;
    // Sort arrays ascendingly
    Arrays.sort(p);
    Arrays.sort(t);
    // Array of pairs
    int[][] pairs = new int[2][shortestLength];
    // Pair the smallest numbers until both arrays have indexes
    for (int i=0; i<shortestLength; i++) {
      pairs[0][i] = p[i];
      pairs[1][i] = t[i];
    }
    return pairs;
  };
}
