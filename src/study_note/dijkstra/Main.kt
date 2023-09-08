package study_note.dijkstra

import java.util.PriorityQueue

fun dijkstra() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() } // 노드 개수, 간선 개수
    val start = readLine()!!.toInt() // 시작 정점
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() } // 노드 연결 정보
    val distance = (0 .. n).map { Int.MAX_VALUE }.toMutableList() // 최단 거리 테이블

    // 모든 간선 입력
    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c)) // a -> b 비용: c
    }

    fun dijkstraSearch(start: Int) {

        // 우선순위 부여
        val queue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
            when {
                p1.second > p2.second -> 1
                p2.second > p1.second -> -1
                else -> 0
            }
        }

        queue.add(Pair(start, 0))
        distance[start] = 0

        while(queue.isNotEmpty()) {
            val(now, dist) = queue.poll() // 최단 거리가 가장 짧은 정보 꺼내기
            if(distance[now] < dist) // 이미 처리된 적 있는 노드
                continue

            // 현재 노드와 인접 노드 확인하기
            for(i in graph[now]) {
                val cost = dist + i.second
                if(distance[now] > cost) { // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    distance[i.first] = cost
                    queue.add(Pair(i.first, cost))
                }
            }
        }
    }

    dijkstraSearch(start) // 탐색 수행

    distance.drop(1).forEach { d ->
        if (d == Int.MAX_VALUE) println("INFINITY") else println(d)
    }
}



