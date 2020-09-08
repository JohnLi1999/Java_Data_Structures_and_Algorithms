package Segment_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {

    @Test
    void testInvalidInput() {
        SegmentTree tree = new SegmentTree(new int[0]);
        assertEquals(0, tree.getSumInRange(0, 1));
    }

    @Test
    void testGetSumInRange() {
        SegmentTree tree = new SegmentTree(new int[] {1, 3, 5, 7, 9, 11});
        assertEquals(1, tree.getSumInRange(0, 0));
        assertEquals(3, tree.getSumInRange(1, 1));
        assertEquals(4, tree.getSumInRange(0, 1));
        assertEquals(5, tree.getSumInRange(2, 2));
        assertEquals(7, tree.getSumInRange(3, 3));
        assertEquals(9, tree.getSumInRange(0, 2));
        assertEquals(9, tree.getSumInRange(4, 4));
        assertEquals(11, tree.getSumInRange(5, 5));
        assertEquals(16, tree.getSumInRange(3, 4));
        assertEquals(27, tree.getSumInRange(3, 5));
        assertEquals(36, tree.getSumInRange(0, 5));
    }

    @Test
    void testUpdate() {
        SegmentTree tree = new SegmentTree(new int[] {1, 3, 5, 7, 9, 11});
        assertEquals(1, tree.getSumInRange(0, 0));
        assertEquals(3, tree.getSumInRange(1, 1));
        assertEquals(4, tree.getSumInRange(0, 1));
        assertEquals(5, tree.getSumInRange(2, 2));
        assertEquals(7, tree.getSumInRange(3, 3));
        assertEquals(9, tree.getSumInRange(0, 2));
        assertEquals(9, tree.getSumInRange(4, 4));
        assertEquals(11, tree.getSumInRange(5, 5));
        assertEquals(16, tree.getSumInRange(3, 4));
        assertEquals(27, tree.getSumInRange(3, 5));
        assertEquals(36, tree.getSumInRange(0, 5));

        // 1 3 5 20 9 11
        tree.update(3, 20);
        assertEquals(1, tree.getSumInRange(0, 0));
        assertEquals(3, tree.getSumInRange(1, 1));
        assertEquals(4, tree.getSumInRange(0, 1));
        assertEquals(5, tree.getSumInRange(2, 2));
        assertEquals(20, tree.getSumInRange(3, 3));
        assertEquals(9, tree.getSumInRange(0, 2));
        assertEquals(9, tree.getSumInRange(4, 4));
        assertEquals(11, tree.getSumInRange(5, 5));
        assertEquals(29, tree.getSumInRange(3, 4));
        assertEquals(40, tree.getSumInRange(3, 5));
        assertEquals(49, tree.getSumInRange(0, 5));
    }
}