// Question: 1642. Furthest Building You Can Reach
// Link: https://leetcode.com/problems/furthest-building-you-can-reach/

// Time Complexity = O(NlogK)
// Space Complexity = O(K)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0) return 0;
        int n=heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // to sort the difference of duilding in ascending order

        for (int i=0; i<n-1; i++) {
            // when the current position is higher than the previous one we need to add it to the priority queue
            if (heights[i] < heights[i+1]) {
                pq.add(heights[i+1]-heights[i]);
            }
            // If we have more jumps than the number of ladders we will have to use bricks, but the bricks should be used for the smallest jumps in order to optimize, so we get the smallest jump from pq and use bricks for those
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            // if we are out of bricks and the pq has jumps equal to ladders we can't reach further, we will return the current building location
            if (bricks < 0) {
                return i;
            }
        }

        return n-1;
    }
}