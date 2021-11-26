### codeup
1. 연달아서 붙이는 print는 printf를 쓰자.
   1. index를 해당번호까지 쓰려고 +1개 추가했더라도, for문에서는 최종index는  length-1까지로 돌려야한다.
   2. sc.nextInt()는 `한줄 입력`도 space단위로 끊어서 받아온다.
2. split()하면 String[]형이다. 
   1. arraylist로 바로 못받는다. -> List.of( s.split(" ") ) 으로 list로 변환후 ArrayList<> (); 의 생성자에 넣어준다.
      1. 배열 -> list -> arraylist
   2. 거꾸로 반복문 돌 땐 ->  int = sizeOrLength `-1` ;  i `>= 0`; i--
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
7. 느낀점
   1. 2차원배열은 각 row마다 밀어넣는데, 붙어있는 문자열이라면, split(" ")말고 toCharArray ''를 쓴다.
   2. DFS, 재귀없는 좌표탐색시, 방향벡터를 돌 때, 모든 방향 다 돌고 나오는게 아니라
       -> **다음좌표찾았으면 break로 자식방향루프 빠져나와서 -> 검사 -> 처음방향부터 순회되도록해야한다.**
       --> 계속해서 그거 돌고 있게 두면 안됨. ex> 동서남북 중 동에서 좌표발견? 좌표업데이트이후 break -> 다시 동부터  ( ->서->남->북 으로 이어지도록 X)
