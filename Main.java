package memo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MemoService memoService = new MemoService();
        memoService.run();
    }
}


/*
ArrayList<Memo> memos = new ArrayList<>();
memos.add(memo1);
memos.add(memo2);
memos.add(memo3);
    memo1 - memo2 - memo3
시간  늦       중       빨
    [0]      [1]     [2]
최신 순 : 2->1->0
<updateMemo>
Memo memo = new Memo(); // 메모 정보를 다 담음.
memo2를 수정하고 싶어!
- memo2를 베낀 메모를 새로 만듬. : memo2' <- 메모 내용, 작성 시간 = 수정 시간으로 변경
- memo2를 지워버림
- memo2' 을 arraylist에 추가!(add)
     memo1 - memo3 - memo2'
시간    늦      중       빨
       [0]    [1]      [2]
수정할 때도, 날짜가 빠른 것부터 출력하는 순서는
인덱스 순서로, 2->1->0
<deleteMemo>
memos.add(memo4);
memos.add(memo5);
    memo1 - memo3 - memo2' - memo4 - memo5
시간   -> 갈수록 최신순.
출력순 : 인덱스 순서로 4->3->2->1->0
memos.updateMemo(memo3);
시간 memo1 - memo2' - memo4 - memo5 - memo3'
시간 -> 갈수록 최신
출력순 : 인덱스 큰 순 -> 작은 순.
memos.delete(memo2');
시간 memo1 - memo4 - memo5 - memo3'
출력순 : 인덱스 큰 순 -> 작은 순
모두 다 ArrayList가 순서를 가지면서 데이터를 저장하냐.
*/
