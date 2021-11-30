## 소개

- 우테코를 진행하는 동안 java에 대한 숙련도를 올리기 위해, 그간 `python_algorithm` repogitory에 학습했던 문제들 중 `구현 문제`위주로 `java`를 통해 풀고 기록하는 레포

### boj

1. 2447
    1. `Arrays.fill( row, 값);` : 2차원배열의 iter에서 row라는 1차원배열을 한번에 채우는 방법
    2. 2차원 문자열 배열의 출력은 for 1r개에 row단위로 출력해버린다.
2. 7568
    1. 1차원 배열 1개로 비교를 한다? -> 반복문 2번을 돌리며, 나자신을 건너뛰게 하자.
    2. `갯수가 정해진 배열`의 새로운 데이터 -> `같은 길이의 배열에다가 새 정보 입력ex>i번째의 랭킹`
3. 10809
    1. python의 string.find -> 인덱스를 반환하며 못찾으면 -1 -> java의 `.indexOf`도 index를 못찾으면 -1을 반환한다.
        1. cf) python의 .index()는 못찾으면 에러발생해서 try catch
    2. python의 string.ascii_lowercase 대신 -> java는 for문에 char c = 'a'부터 담긴 변수를 +1하면 'b'가 되는 매직이 있다.
4. 1110
    1. while () 조건절에 바로 못넣는 상황이라면, 내부 업데이트 직후 바로 if:break검사순으로 넣는다.
    2. 2자리수 제한이라면, /10 이 10의자리, %10이 1의자리가 된다.
        1. 만약 여러자리수라면, 10^(n-1)으로 나눈 몫 -> n번째자리를 1의자리로 끌어온 뒤 -> % 10 -> 1의 자리수만 골라내기
5. 1316
    1. 문자열을 split("")으로 String배열을 만들 수 있지만, 각 알파벳을 아스키코드(-97시 int)로 쓰려면 `toCharArray`를 써서 돌려야한다.
    2. 연속된알파벳의 재등장 감시 -> check배열 [26]개로 생성
        1. chars[i]-97로 각 index에 0부터 a알파벳을 배정함
        2. 재등장 유무 확인방법:
            1. 아직 등장안했으면서 && (`(마지막index아니면서) && 다음꺼(i+1)과는 다르면`) check true
                1. **즉 연속된 것중에 제일 마지막 것(=다음 것과 다름)을 등장단어로 check한다는 개념**
            2. 이미 등장했다면? break
        3. python이라면? sorted(, )기준을 word.find로 두고 정렬하면, 연속된알파벳 재등장시 단어가 엉망으로 정렬되어버림 -> 원본과 다름을 이용한다.
6. 1712
    1. python용: false(null)시 -1출력 ->  none일 때 default값 -1 주기 -> `[조건식] or -1(default)` -> java는 안됨.. boolean과 값을 섞을 수 없음.
    2. `나눠서 남으면 올림` -> python`//`나 java `/`는 나눠서 남으면 내림이다. -> ~~`나눠서 내림이후 +1`~~해주면 된다.
        1. 나눈 뒤 1) 정수냐 -> 그냥 정수그대로.. 2) 소수점있는 실수냐 -> 내림  이 `//`이므로,, +1하면 오류가 생길 수도 
        2. 나눠서 정수냐 아니냐에 따라서 나눠서 계산해야한다. `나눠서 올림`을 해줘도 될 듯 != 나눠서 내린 뒤 +1은 위험하다.
        
### codeup

1. 연달아서 붙이는 print는 printf를 쓰자.
    1. index를 해당번호까지 쓰려고 +1개 추가했더라도, for문에서는 최종index는 length-1까지로 돌려야한다.
    2. sc.nextInt()는 `한줄 입력`도 space단위로 끊어서 받아온다.
2. split()하면 String[]형이다.
    1. arraylist로 바로 못받는다. -> List.of( s.split(" ") ) 으로 list로 변환후 ArrayList<> (); 의 생성자에 넣어준다.
        1. 배열 -> list -> arraylist
    2. 거꾸로 반복문 돌 땐 ->  int = sizeOrLength `-1` ; i `>= 0`; i--
3. split()한건 일단 String[] arr에 담고 -> for문 돌면서 형변환까지 하고 시작하자.
    1. stream으로 splitedString[] -> parseInt -> arraylist를 만들 수 있다.
    ```java
    ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(splitedArr)
          .map(Integer::parseInt)
          .collect(Collectors.toList());
    ```
    2. 원칙 : arr -> list or Collections.addAll -> arraylist -> parseInt
    ```java
    //list
    ArrayList<String> arr = new ArrayList<>(Arrays.asList(splitedArr));
    //Collections.addAll
    ArrayList<String> list = new ArrayList<>();
    Collections.addAll( list ,  splitedArr );
    ```
    3. 참고로 Arrays.setAll(,) 은 배열을 fill()-상수하는 대신, 변형대서 일괄적으로 채운다. 기존 배열 그대로 타입 유지되는 듯 싶다.

4. 이중 배열도 python과 똑같다.
    1. `int[][] arr = new int[19][19];`
        1. defaut로 0이 들어가있는게 특징. String 배열은 null이 들어가 있었음.
    2. 2개가 주어진다면 각각 parsetInt해서 변수에 담아 쓰자.
5. 문자열의 input 행렬이 들어온다면 String[][] 2차원 배열로 parse없이 split만 해서 일단 받자.
    1. `arr[i] = sc.nextLine().split(" ");`로 row단위로 문자열배열을 채워넣어버리자.

6. 좌표계의 막대길이는 시작index를 길이1로 포함하고 시작하는 것
    1. 그러므로 length의 길이를 간다면, `시작index + ( length - 1)` index까지 가야된다.
    2. 좌표계 색칠에서
        1. 좌표계 넘어가면 아예 색칠못함 -> for문 맨 위에서 try catch
        2. 좌표계 넘어가면 무시, 그전까진 색칠 -> 색칠하는 부분에서 try catch
            1. `throw` new 익셉션("멘트");는 `프로그램을 종료`시켜버리므로, 종료시킬때만 던져야함.
            2. 그외에는 catch부분을 `비어둔다` -> 그냥 안하고 `지나간다`.
       ```java
        try {
        arr[i][y - 1] = 1;
        } catch (IndexOutOfBoundsException e) {
        System.out.println(e);
        // throw new ArrayIndexOutOfBoundsException("격자를 넘어간 막대는 무시됩니다.");
        }
        ```
7. 2차원 배열 및 좌표탐색
    1. 2차원배열은 각 row마다 밀어넣는데, 붙어있는 문자열이라면, split(" ")말고 toCharArray ''를 쓴다.
    2. Arrays.fill(arr, 값)으로 빈 배열을 한번에 채울 수 있다.
    3. DFS, 재귀없는 좌표탐색시, 방향벡터를 돌 때, 모든 방향 다 돌고 나오는게 아니라 -> **다음좌표찾았으면 break로 자식방향루프 빠져나와서 -> 검사 -> 처음방향부터 순회되도록해야한다.**
       --> 계속해서 그거 돌고 있게 두면 안됨. ex> 동서남북 중 동에서 좌표발견? 좌표업데이트이후 break -> 다시 동부터  ( ->서->남->북 으로 이어지도록 X)
