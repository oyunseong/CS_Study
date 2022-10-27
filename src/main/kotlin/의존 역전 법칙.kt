/**
 * DIP, Dependency Inversion Principle : 의존 역전 원칙
 * 의존 관계를 맺을 때 변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존하라는 것이다.
 * 한마디로 구체적인 클래스보다 인터페이스나 추상 클래스와 관계를 맺으라는 것
 *
 * 1. 상위 모듈은 하위 모듈에 의존해서는 안된다.
 * 2. 추상화는 세부 사항에 의존해서는 안된다.
 *
 * 즉, 변화하지 않는 것에 의존하라는 원칙!
 *
 * 확장하기 편하게 공통된 부분만 묶어서 변화하지 않게 설정하는 것!
 *
 * 객체간의 관계를 느슨하게 해주는 효과가 있음
 * */

class SamsungPay {
    fun payment(): String {
        return "삼성"
    }
}

// 문제가 있어 다른 PayService 를 다시 만들어야할 때는
// 그때마다 메서드를 다시 만들어야한다.
class PayService {
    var samsungPay = SamsungPay()
    fun setPay(_samsungPay: SamsungPay) {
        samsungPay = _samsungPay
    }
}

interface Pay {
    fun payment(): String
}

class SamsungPay2 : Pay {
    override fun payment(): String {
        return "samsung"
    }
}

class KakaoPay : Pay {
    override fun payment(): String {
        return "kakao"
    }
}

class PayService2() {
    var pay: Pay? = null

    fun payment(): String {
        return pay?.payment().toString()
    }
}

fun main() {
    val payService2 = PayService2()
    val samPay: Pay = SamsungPay2()
    payService2.pay = samPay
    print(payService2.payment())

}