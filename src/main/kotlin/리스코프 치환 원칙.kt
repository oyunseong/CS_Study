/**
 * LSP, Liskov Substitution Principle : 리스코프 치환 원칙
 * 자식 클래스는 언제나 부모 클래스를 대체할 수 있다는 원칙. 즉 부모 클래스가 들어갈 자리에 자식 클래스를 넣어도 계획대로 잘 작동해야 한다.
 * 자식클래스는 부모 클래스의 책임을 무시하거나 재정의하지 않고 확장만 수행하도록 해야한다.
 *
 * 개발자 인터페이스를 확장하는 주니어, 시니어 개발자 클래스를 생성하고
 * 각 클래스에서 이를 상속받는다.
 *
 * 모든 메소드는 정상적으로 실행되고, 부모 클래스는 자식 클래스로 대체가 가능해진 상태이다.
 *
 * 만약 새로운 주니어 또는 시니어 개발자가 입사를하여 클래스를 생성해주어야 하는 상황이면
 * 주니어 또는 시니어 개발자 클래스를 상속시키고 필요한 메서드를 구현하면 된다.
 *
 * 핵심 : 구현한 부모 클래스의 원칙을 자식 클래스에서 깨지 않는 것
 *
 * 추가적인 원칙
 * 1. 하위형에서 선행 조건은 강화될 수 없다.
 *    ㄴ 함수가 오류 없이 실행되기 오ㅟ한 모든 조건을 정의하는 것을 의미
 *
 * 2. 하위형에서 후행조건은 약화될 수 없다.
 *    ㄴ 후행 조건은 수행이 완료된 후에 만족되어야 하는 조건을 의미
 *
 * 3. 하위형에서 상위형의 불변조건은 반드시 유지되어야 한다.
 *
 * */

abstract class Developer {
    abstract fun develop()
    abstract fun meeting()
    abstract fun presentation()
}

class Junior() : Developer() {
    override fun develop() {
        print("주니어 개발")
    }

    override fun meeting() {
        print("주니어 미팅")
    }

    // 자식 타입이 부모 타입의 동작을 실행하지 못하는 경우
    // 주니어 타입은 개발자 클래스를 대체할 수 없다.
    override fun presentation() {
        throw Error("주니어는 못해")
    }
}

class Senior() : Developer() {
    override fun develop() {
        print("시니어 개발")
    }

    override fun meeting() {
        print("시니어 개발")
    }

    override fun presentation() {
        print("시니어 개발자 프레젠테이션")
    }
}

fun main() {
    val devA = Junior()
    val devB = Senior()

    devA.develop()
    devB.develop()

    devA.meeting()
    devB.meeting()

    devA.presentation() // Error!
    devB.presentation()
}


// 2. 하위형에서 후행조건은 약화될 수 없다.
// 채용 절차에서는 지원자를 받고 지원자에서는 이름을 받아 String 체크를 하고있다.
// 잡 코리아(자식)에서는 실수로 String이 아닌 값을 입력해도 예외 처리가 되지않아 잘못된
// 값을 갖을 수 있다. 즉, 반환하는 값에 대한 조건을 약화시킨 것
// ( 조건을 약화시키지 말고 잘 지켜야한다는 뜻! )

class 채용절차(private val 지원자: 지원자) {
    fun 서류(이름: Any) {
        try {
            지원자.서류지원(이름)
            면접()
        } catch (exception: Exception) {
            println(exception)
        }
    }

    private fun 면접() {
        println("면접 중. . .")
    }
}

open class 지원자 {
    open fun 서류지원(이름: Any): Any {
        if (이름 !is String) {
            throw Error("이름란에는 문자열 입력만 가능합니다!")
        }
        return 이름
    }
}

class 잡코리아_지원자 : 지원자() {
    override fun 서류지원(이름: Any): Any {
        return 이름
    }
}

class 원티드_지원자 : 지원자() {
    override fun 서류지원(이름: Any): Any {
        if (이름 !is String && 한글체크()) {
            throw Error("문자열을 입력하지 않았거나 한글 기입을 하지 않았습니다!")
        }
        return 이름
    }
}

fun 한글체크(): Boolean {
    val result = false
    // 한글인지 체크. . .
    return result
}

// 3. 하위형에서 상위형의 불변 조건은 반드시 유지되어야 한다.
// 부모(지원자2)에서는 나이가 0 또는 양수가 되는 조건으로 설정되어있는 상태
// 자식(잡코리아)에서 나이를 조건없이 수정하게 해서 불변조건을 깨버린 상태
open class 지원자2() {
    var 나이 = 0

    open fun 나이_수정(나이: Int) {
        if(나이 < 0) this.나이 = 0
        else this.나이 = 나이
    }
}

class 잡코리아_지원자2 : 지원자2() {
    override fun 나이_수정(나이: Int) {
        this.나이 = 나이
    }
}