package Basic.constate;

public class SwitchExample {

    public static void main(String[] args) {

        String gender = "g";

        // 분기를 나눌 기준값이 괄호 안에 들어감. (문자열, 정수만 가능)
        switch (gender) {
            case "m": case "M":
                System.out.println("man");
                break;

            // java 14 ver 이후의 개선된 case문.
            case "F", "f":
                System.out.println("woman");
                break;

            default: // case를 설정하는 값들
                System.out.println("who?");

        }
    }
}
