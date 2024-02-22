package data_structures.utilities;

public class Utils {

    /**
     * A null safe equals check for two objects. Returns true if both objects are equal (or both null).
     */
    public static <T> boolean equals(T a, T b) {
        return (a == null && b == null) || (a != null && a.equals(b));
    }
}
