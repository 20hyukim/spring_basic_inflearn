package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 private, static으로 가지고 있음
    private static final SingletonService instance = new SingletonService();

    // 항상 같은 인스턴스만 반환
    public static SingletonService getInstance() {
        return instance;
    }

    // private 로 선언
    private SingletonService(){}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
