import java.lang.reflect.Type
import java.util.*
import javax.sound.sampled.AudioFileFormat
import kotlin.reflect.typeOf

/**
 * 절차지향 프로그래밍
 * 데이터보다는 해당 프로그램이 하고자하는 목적을 중심으로 짜여진다.
 * 함수는 독립적인 존재
 * ㄴ 클래스 함수가 아닌 전역 함수이다.
 * ㄴ 누구나 호출 가능하다.
 * ㄴ 특정 데이터에 종속되어 있지 않다.
 * */


fun add(x: Int, y: Int): Int {
    return x + y
}

fun minus(x: Int, y: Int): Int {
    return x - y
}

// 계산기를 구현하는 상황이라고 가정할 때
// type = a : 공학용 계산기
// type = b : 일반 계산기
fun main(args: Array<String>) {
    val arr = readLine()?.split(' ')
    val a = arr!![0].toInt()
    val b = arr[1].toInt()
    val operator = arr[2]
    val type = arr[3]
    print(type)
    if (type == 'a'.toString()) { // 공학용 계산기
        when (operator) {
            "+" -> add(a, b)
            "-" -> minus(a, b)
        }
    }else{  // 일반 계산기
        when (operator) {
            "+" -> add(a, b)
            "-" -> minus(a, b)
        }
    }
}

