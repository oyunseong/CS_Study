/**
 * 순수함수
 * */
fun pureFunction(a: Int, b: Int): Int {
    return a + b
}

val anonymousFunction = fun() { print("익명함수입니다.") }

val lambdaFunction: () -> Unit = {}

var cnt = 0

// 익명 콜백 함수
val callbackFunction = fun() {
    print("Im callbackFunction")
    cnt += 1
}

// 고차함수
// 인자를 함수로 받음
fun higherOrderFunction(func: () -> Unit): () -> Unit {
    callbackFunction.invoke() // 콜백 함수 호출
    return lambdaFunction   // 반환값을 함수로 사용
}


fun main() {
    higherOrderFunction(lambdaFunction)
}