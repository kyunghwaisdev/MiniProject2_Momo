package memo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoVO {
    //변수
    // private static int memoNum;  //입력할 글번호????? >글번호 증가할 때 사용할 변수..?
    private int no;                        //특정메모의 글번호 ????>인덱스 넘버..?
    private String name;
    private String password;
    private String content;

    private String memoDate;//임시



    public MemoVO(String name, String password, String content){
        this.no = MemoList.memoNum++;   // 1씩 증가
        this.name = name;
        this.password = password;
        this.content = content;
        this.memoDate = setConstructTime();
    }

    // Only for MemoList.updateMemo() method
    public MemoVO(int contentNum, String name, String password, String content){
        this.no = contentNum;
        this.name = name;
        this.password = password;
        this.content = content;
        this.memoDate = setConstructTime();
    }

    private String setConstructTime() {
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss");

        return dtf.format(date);
    }

    // getter
    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContent() {
        return content;
    }

    public String getMemodate() {
        return memoDate;
    }
}
