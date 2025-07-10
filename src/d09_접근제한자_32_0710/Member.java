package d09_접근제한자_32_0710;

public class Member {

    // 1. 멤버변수
    private String id;

    // 2. 생성자

    // 3. 메소드(Getter/Setter)
    // 3.1. Setter
    public String setId( String id){
        this.id = id;
        return id;

    }// func end


    // 3.2. Getter
    public String getId( ){

        return id; // 매개변수가 없어서 그냥 멤버 변수를 적어도 되뮤...

    }// func end

} // class end
