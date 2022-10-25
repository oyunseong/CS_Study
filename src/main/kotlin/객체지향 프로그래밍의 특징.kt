/**
 * 추상화 : 핵심적인 기능을 간추려내는 것
 * 공통점을 뽑아낸다.
 * */
abstract class Animal {
    abstract val name: String   // 모두가 가지고있는 이름
    abstract val kind: String    // 당도

    abstract fun crying()
    abstract fun working()

    fun attack() {
        print("동물 펀치")
    }
}

/**
 * 상속성 : 자식클래스가 부모의 특성과 기능을 물려받는 것
 * */
class Cat : Animal() {
    override var name: String = "나비"
    override val kind: String = "먼치킨"

    override fun crying() {
        print("애옹")
    }

    override fun working() {
        print("총총총")
    }

    /**
     * 캡슐화 : 객체의 내부 구조 및 데이터를 캡슐처럼 감싸 외부에서 직접 볼 수 없게 은닉하여 보호하는 것
     * setName()라는 함수를 사용해 캡슐안에 있는 name 변수에 접근할 수 있음
     */
    @JvmName("setName1")
    fun setName(name: String) {
        this.name = name
    }
}


/**
 * 다형성 : 하나의 메서드나 클래스가 다양한 방법으로 동작하는 것
 * */
fun overloadingFunc(x: Int) {
    print("파라미터 하나")
}

fun overloadingFunc(x: Int, y: Int) {
    print("파라미터 둘")
}

fun main() {
    val cat = Cat()
    cat.attack()    // 상속받은 기능 사용
    cat.setName("냐옹이") // 캡슐화한 변수에 접근
}





