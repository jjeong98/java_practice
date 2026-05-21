package etc.fileio.policy;


// 인터페이스는 자체 객체를 생성 할 수 없음
// 각각의 클래스들에게 역할을 부여하는 캘래스의 틀 역할.
// "이 역할을 가진 객체는 이런 메서들을 제공해라."
public interface Reviewable {

// 인터페이스에 변수 를 선언하면 상수 취급/ 필드가 아님.
	int i = 10;
	
//	Reviewable() {
//
//	} 생성자가 없기 때문에 객체 안 됨.
	
	
	boolean needReview();
	
	void printReviewTarget();
	
	
}
