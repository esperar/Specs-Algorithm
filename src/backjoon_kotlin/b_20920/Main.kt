package backjoon_kotlin.b_20920

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val wordNumbers = hashMapOf<String, Int>()

    repeat(n) {
        val inputWord = readLine()
        if(inputWord.length >= m) {
            wordNumbers.merge(inputWord, 1, Integer::sum)
        }
    }

    val result = wordNumbers.entries.sortedWith(kotlin.Comparator { o1, o2 ->
        when {
            o1.value != o2.value -> {
                o2.value.compareTo(o1.value)
            }

            o1.key.length != o2.key.length -> {
                o2.key.length - o1.key.length
            }

            else -> {
                o1.key.compareTo(o2.key)
            }
        }
    })

    result.forEach {
        bw.write("${it.key}\n")
    }
    bw.flush()
    bw.close()
}