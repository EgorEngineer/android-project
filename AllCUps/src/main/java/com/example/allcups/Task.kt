package com.example.allcups

fun task1(){
    val firstLine = readLine()!!.trim()
    val (m, n) = firstLine.split(" ").map { it.toInt() }
    val arr = readLine()!!.trim().split(" ").map { it.toInt() }
    val uniqueDesc = arr.distinct().sortedDescending()

    if (n > uniqueDesc.size)
        println(-1)
    else
        println(uniqueDesc[n - 1])
}

fun task2(a: Long, b: Long) : Long{
//    val part1 = task2(a-1,b)
//    val part2 = task2(a-1-b * task2(a-1,b),b-1)
//    val rez = part1 + part2
//    if(a.equals(0) or b.equals(0))
//        return rez
//    else
//        return rez
    val (a,b) = readln().trim().split(" ").map { it.toLong() }
    println(a/b)
    return(a / b)
}

fun task3() {
    val n = readLine()!!.trim().toInt()
    val occupied = BooleanArray(n + 1)

    while (true) {
        val x = readLine()?.trim()?.toIntOrNull() ?: break
        if (x in 1..n)
            occupied[x] = true
    }

    val sb = StringBuilder()
    var first = true

    for (i in 1..n) {
        if (!occupied[i]) {
            if (!first)
                sb.append('\n')
            sb.append(i)
            first = false
        }
    }
    print(sb)
}

fun task4(){
    val input = readln().trim()
    var flagV = false
    var flag_v = false
    var flagK = false
    var flag_k = false

    for(i in input){
        if(i == 'v') flag_v = true
        if(i == 'V') flagV = true
        if(i == 'k') flag_k = true
        if(i == 'K') flagK = true
    }

    if(flagV && flagK) println("VK")
    else if(flag_v && flag_k) println("vk")
    else println(":(")
}

fun main() {
    val n = readLine()!!.trim().toInt()

    val busy = BooleanArray(1_000_000)
    repeat(n) {
        busy[readLine()!!.trim().toInt()] = true
    }

    val out = StringBuilder()
    for (number in 0 until n) {
        if (!busy[number]) {
            out.append(number.toString().padStart(6, '0')).append('\n')
        }
    }
    print(out)
}


class Task {

}