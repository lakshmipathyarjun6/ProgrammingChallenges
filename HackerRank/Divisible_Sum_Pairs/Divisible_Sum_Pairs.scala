object Solution {

    def numSumPairs(vals: Array[Int], k: Int) {
        var total = 0;
        for(a_i <- 0 to (vals.length-1)) {
            for(a_j <- (a_i+1) to (vals.length-1)) {
                var divisible = if ((vals(a_i) + vals(a_j)) % k == 0) 1 else 0;
                total += divisible;
            }
        }
        println(total);
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var k = sc.nextInt();
        var a = new Array[Int](n);
        for(a_i <- 0 to n-1) {
           a(a_i) = sc.nextInt();
        }
        numSumPairs(a,k);
    }
}
