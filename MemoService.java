package memo;

import java.text.NumberFormat;
import java.util.Scanner;

public class MemoService {

    void run(){

        MemoList memoList = new MemoList();

        while(true){
            showMenu();

            // 사용자에게 1~5번 사이 숫자를 받는다.
            Scanner s = new Scanner(System.in);

            int userInputNumber = -1;

            try {
                userInputNumber = Integer.parseInt(s.nextLine());
            } catch(NumberFormatException e){
                System.out.println("잘못된 입력입니다. 1~5사이 숫자로 다시 시도해주세요");
            }

            switch(userInputNumber){
                case 1:    // 1. 메모 쓰기
                    System.out.println("이름을 입력해주세요.");
                    String name = s.nextLine(); // 유저이름
                    System.out.println("비밀번호를 입력해주세요.");
                    String password = s.nextLine();
                    System.out.println("메모 내용을 자유롭게 작성해주세요");
                    String content = s.nextLine();
                    memoList.addMemo(name, password, content);
                    break;
                case 2:     // 2. 메모 목록보기
                    memoList.showAllMemos();
                    break;
                case 3:     // 3. 메모 수정하기
                    System.out.println("수정할 글 번호를 입력해주세요.");

                    int memoNumUp = -1;    // 초기값 설정. 글 번호에는
                    // memoNumUp => 업데이트 시키고 싶은 글번호
                    try {
                        memoNumUp = Integer.parseInt(s.nextLine());
                    }catch(NumberFormatException e){    // 정수가 아닌 이상한 값을 입력할 때.
                        System.out.println("잘못된 입력입니다. 정수값을 입력해주세요.");
                    }

                    if( memoNumUp == -1 ) // 잘못 입력했으면 break로 빠져나감.
                        break;

                    if ( memoList.checkMemoExistOrNot(memoNumUp) ) {  // 찾는 번호의 메모 존재 시

                        System.out.println("글의 비밀번호를 입력해주세요.");
                        String pw = s.nextLine();

                        if(pw.equals(memoList.getMemoPasswordByNum(memoNumUp))){
                            System.out.println("수정할 내용 작성 : ");
                            String newContent = s.nextLine();
                            memoList.updateMemo(memoNumUp, newContent);
                        } else {            // 비밀번홀가 틀렸다면
                            System.out.println("비밀번호가 틀렸습니다.");
                        }
                    } else {    // 찾는 번호의 메모 존재 x
                        System.out.println("찾으시는 번호에 해당하는 메모가 없습니다.");
                    }

                    break;

                case 4:             // 4. 메모 삭제
                    System.out.println("삭제할 글 번호를 입력해주세요.");

                    int memoNumDel = -1;    // 초기값 설정. 글 번호에는
                    // memoNumDel => 삭제하고 싶은 글번호
                    try {
                        memoNumDel = Integer.parseInt(s.nextLine());
                    }catch(NumberFormatException e){    // 정수가 아닌 이상한 값을 입력할 때.
                        System.out.println("잘못된 입력입니다. 정수값을 입력해주세요.");
                    }

                    if( memoNumDel == -1 ) // 잘못 입력했으면 break로 빠져나감.
                        break;

                    if ( memoList.checkMemoExistOrNot(memoNumDel) ) {  // 찾는 번호의 메모 존재 시

                        System.out.println("글의 비밀번호를 입력해주세요.");
                        String pw = s.nextLine();

                        if(pw.equals(memoList.getMemoPasswordByNum(memoNumDel))){
                            memoList.deleteMemo(memoNumDel);
                        } else {            // 비밀번홀가 틀렸다면
                            System.out.println("비밀번호가 틀렸습니다.");
                        }
                    } else {    // 찾는 번호의 메모 존재 x
                        System.out.println("찾으시는 번호에 해당하는 메모가 없습니다.");
                    }

                    break;
                case 5:
                    System.out.println("정상적으로 종료되었습니다.");
                    System.exit(0);
                    break;
                case -1:    // 잘못 입력한 경우이기에 아무 일도 일어나지 않음.
                    ;
            }


        }
    }

    void showMenu(){
        System.out.println("=====================");
        System.out.println("1. 메모 쓰기");
        System.out.println("2. 메모 목록보기");
        System.out.println("3. 메모 수정하기");
        System.out.println("4. 메모 삭제하기");
        System.out.println("5. 종료");
        System.out.println("=====================");
        System.out.println("입력 : ");
    }

}
