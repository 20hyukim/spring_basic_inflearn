package hello.core;

import ch.qos.logback.core.net.SyslogOutputStream;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
    //    AppConfig appConfig = new AppConfig();
    //    MemberService memberService = appConfig.memberService();

        /* ApplicationContext가 스프링 컨테이너라고 보면 됨.
         * AppConfig에 Bean으로 설정된 것의 객체들을 컨테이너에 넣고 관리해 주게 됨.
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에 있는 함수의 이름을 통해 bean을 가져 옴. // 두 번째 인자는 반환 타입을 의미
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
