/**
 * ISP, Interface Segregation Principle : 인터페이스 분리 원칙
 * 한 클래스는 자신이 사용하지않는 인터페이스는 구현하지 말아야 한다. 하나의 일반적인 인터페이스보다 여러개의 구체적인 인터페이스가 낫다.
 *
 * 1. 클라이언트는 자신이 사용하지 않는 메소드에 의존해선 안된다.
 *    ㄴ 아래 예시처럼 모든 스마트폰에 삼성페이를 넣으면 삼성이 아닌 폰에서도 삼성페이 메서드를 갖게된다.
 *
 * ISP를 준수하면 유지보수에 용이해진다!
 * */


interface 스마트폰 {
    fun 전화(전화_상대: String)
    fun 문자(문자_상대: String)
    // fun 삼성페이()
}

interface 삼성폰 {
    fun 삼성뮤직()
    fun 삼성페이()
}

interface 애플폰 {
    fun 애플뮤직()
    fun 애플페이()

}

class 갤럭시 : 스마트폰, 삼성폰 {
    override fun 전화(전화_상대: String) {
        // TODO : 갤럭시 전화
    }

    override fun 문자(문자_상대: String) {
        // TODO : 갤럭시 문자
    }

    override fun 삼성뮤직() {
        // TODO : 삼성 뮤직
    }

    override fun 삼성페이() {
        // TODO : 삼성페이
    }
}

class 아이폰 : 스마트폰, 애플폰 {
    override fun 전화(전화_상대: String) {
        // TODO : 아이폰 전화
    }

    override fun 문자(문자_상대: String) {
        // TODO : 아이폰 문자
    }

    override fun 애플뮤직() {
        // TODO : 애플 뮤직
    }

    override fun 애플페이() {
        // TODO : 애플페이
    }
    // override fun 삼성페이()
}