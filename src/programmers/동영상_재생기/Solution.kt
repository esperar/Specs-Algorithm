package programmers.동영상_재생기

class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val videoLenSecond = convertToSecond(video_len)
        var posSecond = convertToSecond(pos)
        val opStartSecond = convertToSecond(op_start)
        val opEndSecond = convertToSecond(op_end)

        if(posSecond in opStartSecond .. opEndSecond) posSecond = opEndSecond

        for(command in commands) {
            when(command) {
                "next" -> {
                    posSecond += 10
                    if(posSecond > videoLenSecond) posSecond = videoLenSecond
                }
                "prev" -> {
                    posSecond -= 10
                    if(posSecond < 0) posSecond = 0
                }
            }
            if(posSecond in opStartSecond .. opEndSecond) posSecond = opEndSecond

        }

        return convertToTime(posSecond)
    }

    private fun convertToSecond(time: String): Int {
        val timeSlice = time.split(":").map { it.toInt() }.toIntArray()
        val mm = timeSlice[0]
        val ss = timeSlice[1]

        return mm * 60 + ss
    }

    private fun convertToTime(time: Int): String {
        val mm = time / 60
        val ss = time % 60
        return String.format("%02d:%02d", mm, ss)
    }

}


