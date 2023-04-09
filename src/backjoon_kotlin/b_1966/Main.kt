package backjoon_kotlin.b_1966

import java.util.*

fun main(args: Array<String>) {
    val t: Int = Integer.parseInt(readLine())

    for(i in 1..t) {
        var st = StringTokenizer(readLine())
        val n: Int = Integer.parseInt(st.nextToken())
        val target: Int = Integer.parseInt(st.nextToken())

        val que: Queue<Pair<Int, Int>> = LinkedList()
        val pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        var count = 0

        st = StringTokenizer(readLine())
        for(j in 0 until n) {
            val priority: Int = Integer.parseInt(st.nextToken())
            que.offer(Pair(j, priority))
            pq.offer(priority)
        }
        while(!que.isEmpty()) {
            val job: Pair<Int, Int> = que.poll()
            if(job.second == pq.peek()) {
                count++
                pq.poll()
                if(job.first == target) {
                    break
                }
            } else {
                que.offer(job)
            }
        }
        println(count)
    }
}