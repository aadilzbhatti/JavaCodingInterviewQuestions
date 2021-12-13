package interviewing.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {

    @Test
    public void test() {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.mergeSets(2, 3);

        assertEquals(2, ds.find(3));

        ds.makeSet(4);
        ds.makeSet(5);
        ds.mergeSets(4, 5);
        ds.mergeSets(2, 4);

        assertEquals(2, ds.find(4));
        assertEquals(2, ds.find(5));

        ds.makeSet(7);
        ds.mergeSets(7, 2);

        assertEquals(7, ds.find(2));
        assertEquals(7, ds.find(3));
        assertEquals(7, ds.find(4));
        assertEquals(7, ds.find(5));

        ds.mergeSets(7, 1);

        assertEquals(7, ds.find(1));
    }
}