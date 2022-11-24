package memo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class MemoList {
    private ArrayList<MemoVO> memos;
    public static int memoNum = 0;

    public MemoList(){
        this.memos = new ArrayList<>();
    }

    public void addMemo(String name, String password, String content){
        MemoVO memo = new MemoVO(name, password, content);
        memos.add(memo);
    }

    public void showAllMemos(){

        // for문 돌려서, 저거 걍 출력하면 됨. 포맷에 맞춰서.

        for(int i = memos.size()-1 ; i>=0; i--) {
            MemoVO memo = memos.get(i);

            String memoContentSample = "";

            if (memo.getContent().length() < 10)         // 10글자 미만일 때는 그냥 보여줌
                memoContentSample = memo.getContent();
            else                                        // 10글자 이상일 때는 10자까지 짤라 보여 줌.
                memoContentSample = memo.getContent().substring(0, 10);

            System.out.println("글 번호 : " + memo.getNo() + "\n작성자 : " + memo.getName() + "\n내용 : "
                    + memoContentSample + "\n시간 :" + memo.getMemodate() + "\n====================");
        }
    }

    public boolean checkMemoExistOrNot(int memoNum) {
        for( MemoVO memo : memos ){
            if(memo.getNo() == memoNum)
                return true;    // 존재함!
        }
        return false;   // 존재하지 않는 경우 false.
    }



    public String getMemoPasswordByNum(int memoNum){
        for( MemoVO memo : memos ){
            if( memo.getNo() == memoNum) {
                System.out.println("가게 해줘 ( if문 들어옴 )");
                return memo.getPassword();
            }
        }
        return "";
    }

    public void updateMemo(int memoNum, String newContent){
        for( MemoVO memo : memos){
            if( memo.getNo() == memoNum ){  // 주어진 글 번호와 메모리스트가 관리하는 메모의 글 번호가 동일하면 = 내가 수정하고자 하는 메모라면
                System.out.println("updateMemo() if문 들어옴.");
                MemoVO newMemo = new MemoVO(memo.getNo(),memo.getName(), memo.getPassword(), newContent);

                memos.remove(memo); // 해당 메모 삭제, 그 이후에 다시 새로운 메모를 append 해줌. = MemoVO에 setter를 만들지 않기 위함.
                System.out.println("updateMemo() remove 연산 수행.");
                memos.add(newMemo);

                break;
            }
        }

    }

    public void deleteMemo(int memoNum){
        for ( MemoVO memo : memos ){
            if ( memo.getNo() == memoNum ) { // 내가 삭제하고자 하는 메모라면
                memos.remove(memo); // 해당 메모 삭제
                break;
            }
        }
    }

}


//static class DateComparator implements Comparator<MemoVO> {
//    @Override
//    public int compare(MemoVO o1, MemoVO o2){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//        Date day1 = null;
//        Date day2 = null;
//
////        try {
////            day1 = format.parse(o1.getMemodate());
////        }
//    }
//}
