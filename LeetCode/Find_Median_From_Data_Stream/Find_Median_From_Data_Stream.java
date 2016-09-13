public class MedianFinder {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2){
            return -i1.compareTo(i2);
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.offer(num);
        } 
        else {
            if(minHeap.size() == 0) {
                Integer current = maxHeap.poll();
                if(num < current) {
                    maxHeap.offer(num);
                    minHeap.offer(current);
                }
                else {
                    maxHeap.offer(current);
                    minHeap.offer(num); 
                }
            }
            else {
                if(num < maxHeap.peek()) {
                    maxHeap.offer(num);
                }
                else {
                    minHeap.offer(num);
                }
            }
        }
        if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
