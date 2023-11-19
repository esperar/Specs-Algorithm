package backjoon_kotlin.b_22858

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    var S = readLine().split(" ").map { it.toInt() }.toIntArray()
    val D = readLine().split(" ").map { it.toInt() }.toIntArray()

    // 두번째에 있는 D의 인덱스로

    /**
     *
    (n ,k) = 5, 2
    S: 4 1 3 5 2
    D: 4 3 1 2 5
    P: 1 4 5 3 2

     다시 되돌리기하려면 S가 두번 섞은거니까 다
     각 i에 대해 Di번째 카드를 i번째로 가져오는 작업을 셔플이라고 한다면 셔플을 되돌리려면
     i번째 카드를 Di번째로 다시 가져가면 역 셔플이 아닐까
     그러면 S(결과에다가) 현재 D를 기준으로 k번 역셔플을 돌리면 P가 출력되지 않을까

     한번 시뮬레이션 해보면
     현재 S: 4 1 3 5 2
         D: 4 3 1 2 5
     역셔플1 S: 3 5 1 4 2
     역셔플2 S: 1 4 5 3 2 - 정답

     와 나 천재인가
     */

    val result = IntArray(n)

    repeat(k) {
        for(i in 0 until n) {
            // result에 역셔플 기록을 저장하고 마지막에 S랑 스왑해준다.
            result[D[i] - 1] = S[i]
        }
        S = result.copyOf() // 그냥 result를 대입하면 같이 참조되어 값이 result 변할때마다 S 배열도 바뀌기 때문에 copy를 넣어준다.
    }

    println(S.joinToString(separator = " "))

}