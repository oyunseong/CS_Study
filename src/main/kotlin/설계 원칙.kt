/**
 * OCP,Open Closed Principle : 개방-폐쇄 원칙
 *  확장에는 열려 있어야하고, 변경에는 닫혀 있어야한다.
 *  기능이 변하거나 확장되는 것은 가능하지만 그 과정에서 기존의 코드가 수정되지 않아야한다.
 *  예시) 라이브러리를 사용하는 객체의 코드가 변경된다고 해서 라이브러리의 코드가 변경된다고
 *  라이브러리의 코드까지 변경하지는 않는다.
 *  아래는 원칙을 위반한 예시 코드
 * */

// 각 객체가 생성될 때부터 각 차량 클래스에 과하게 의존하고 있다.
// 만약 c의 운전자의 차량이 바뀌면, 운전자 c의 객체를 다시 생성해야한다.
// 코드 자체가 수정되는 상황은 OCP를 위배한다. `
fun main() {
    val a = Sonata()
    a.drive()
    val b = BMW()
    b.drive()
    val c = SUV()
    c.drive()

    val d= Carnival("")

}

class Sonata {
    fun drive() {
        print("소나타")
    }
}

class BMW {
    fun drive() {
        print("BMW")
    }
}

class SUV {
    fun drive() {
        print("SUV")
    }
}

// drive 메서드는 자동차가 바뀌더라도 변경되지 않는다. 자동차의
// 변경과 확장성에 대해서는 개방되어 있고, 어떤 차를 타도 운전 방법이 수정되지 않게
// 폐쇄되어있는 코드이다.
open class Car() {
    var name: String = ""
    fun drive() {
        print("$name 차 입니다.")
    }
}

class Carnival(_name: String) : Car() {
    init {
        name = _name
    }
}

class Grandeur(_name: String) : Car() {
    init {
        name = _name
    }
}

