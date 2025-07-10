package d09_접근제한자_32_0710;

public class Score {
    
    // 1. 멤버 변수

    private int score;
    
    // 2. 생성자
    
    // 3. 메소드

    public void setScore(int score){

        if( score >= 0 && score <= 100 ){
            this.score = score;
            System.out.println( score );

        }else {
            System.out.println("유효하지 않은 점수입니다.");
        }

    }


} // class end
