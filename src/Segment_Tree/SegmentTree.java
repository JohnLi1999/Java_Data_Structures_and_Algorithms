package Segment_Tree;

public class SegmentTree {

    private SegmentTreeNode root;
    private int[] nums;

    public SegmentTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        this.nums = nums;
        root = buildTree(0, nums.length - 1);
    }

    /**
     * Returns the sum of the elements between
     * indices start and end (start ≤ end), inclusive.
     *
     * @param start the start index
     * @param end   the end index
     * @return      the sum of elements between start and end index
     */
    /*  Time Complexity: O(N*log(N))  */
    public int getSumInRange(int start, int end) {
        return root != null ? getSumInRange(root, start, end) : 0;
    }

    /**
     * Modifies nums by updating the element at index i to val.
     *
     * @param pos   the position needs to be updated
     * @param val   the updated value
     */
    /*  Time Complexity: O(N*log(N))  */
    public void update(int pos, int val) {
        int diff = nums[pos] - val;
        nums[pos] = val;

        if (root != null) {
            update(root, pos, diff);
        }
    }

    /*  Time Complexity: O(N)
            Need to traverse all the elements in the array
     */
    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }

        return node;
    }

    /*  Time Complexity: O(N*log(N))  */
    private int getSumInRange(SegmentTreeNode root, int start, int end) {
        // Return 0 if the range [start, end] is completely outside of the range [root.start, root.end]
        if (root == null || end < root.start || start > root.end) {
            return 0;
        }

        /*  Return the sum of current range
            if the range [start, end] is completely inside of the range [root.start, root.end]
         */
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }

        // Recursively check for both left and right children
        int leftSum = getSumInRange(root.left, start, end);
        int rightSum = getSumInRange(root.right, start, end);

        // Return the sum of the left child and right child
        return leftSum + rightSum;
    }

    /*  Time Complexity: O(N*log(N))  */
    private void update(SegmentTreeNode root, int pos, int diff) {
        // Return if the position is outside of the range [root.start, root.end]
        if (root == null || pos < root.start || pos > root.end) {
            return;
        }

        /*  Update the sum of current range
            if the position is inside of the range [root.start, root.end]
         */
        if (pos >= root.start && pos <= root.end) {
            root.sum -= diff;
        }

        // Recursively Check for both left and right children
        update(root.left, pos, diff);
        update(root.right, pos, diff);
    }
}

class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
