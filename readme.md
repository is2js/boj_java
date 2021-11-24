## codeup
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
4. 이중 배열도 python과 똑같다.
      1. `int[][] arr = new int[20][20];`
         1. defaut로 0이 들어가있는게 특징. String 배열은 null이 들어가 있었음.
      2. 2개가 주어진다면 각각 parsetInt해서 변수에 담아 쓰자.