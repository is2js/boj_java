### stream 개념 및 예제코드 정리

1. list 중복확인 -> list`.stream().distinct()` + `.count()`와 원본.size()를 비교
2. list **중복제거** -> list`.stream().distinct()` + `.collect(Collectors.toList())`로 중복제거한 리스트 뽑기
3. arr 합치기 -> Stream.of( arr1, arr2) `.flatMap(Stream::of)` .collect(Collectors.toList());ㄴ
4. 문자열array -> List<Integer> 형변환 -> Arrays.stream( arr )`.mapToInt(Integer::parseInt).boxed()`.collect(
   Collectors.toList())
5. 문자 대소문자 전환 ->  List<String>이면 대소문자 변환 가능 list.stream() + `.map(String::toUpperCase)`
6. 숫자 값 변경 -> List<Integer>면 숫자변환 가능 list.stream() + `map(x -> x*x)`
7. 문자열 길이 확인하기 `map, mapToInt 등의 직접 변환안하고` filter, anyMatch안에서 조건식만 작성
    - Arrays.stream(stringsArray).anyMatch(s -> `s.length() < 1`);
8. 문자열 길이의 최대`값`( `원본X 값뽑기` -> IntStream 형 전환후 바로 max() )
    - Arrays.stream(lines)
      .mapToInt(String::length)
      .max()
      .orElseThrow(NoSuchElementException::new);

9. 고난도
    2. list -> 문자열 합치기: hashSet.stream()`.map(Object::toString).reduce((a,b)->a+b).get()`;
    3. 원소Class가 가진 isXXX, hasXXX메서드를 통해, 해당하는 것 있는지 검색할 때
        - return this.result.stream()`.anyMatch(Scores::hasStrike)`;
        - return this.scores.stream().anyMatch(Score::isStrike);
        - return this == STRIKE;
    4. Enum 속 finder로 분기별 처리되도록 검색할 때
        - return Arrays.stream( OperateType.values())
          .filter( e -> e.symbol.equals( symbol ))
          .findAny()
          .orElseThrow( () -> new IllegalArgumentException("not a arithmetic symbols"));
    5. list의 집계함수 만들기
        - list의 집계를 reduce().get() + Integer::sum 으로 구하기 return list.stream()
          .reduce(Integer::sum)
          .get();
    6. enum finder 속 filter에 들어갈 또다른 람다식으로 boolean식 만들기
        - Arrays.stream(Program.values())
          .filter(e -> e.list.stream().anyMatch(element -> element.equals(name)))
          .filter(hasNameInGroup(name))
          .findAny()
          .orElseThrow(() -> new IllegalArgumentException("없는 프로그램입니다."));
    7. 음수검사: IntStream만들어서 custom boolean식 만들고 filter에 넣기
        - Arrays.stream(mathexpression.split(",|:"))
          .mapToInt(Integer::parseInt)
          .filter(i -> checkNegative(i))
          // .sum();
    8. 숫자사이 연산자들의 연속입력 검사
        - if (Arrays.stream(removedSpaceInput.split("[0-9]")).anyMatch(operator -> operator.length() > 1)) {
    9. 객체list -> Map 만들기
        - Map<Integer, String> map = list.stream()
          // .sorted(Comparator.comparingInt(Item::getId).reversed())
          .collect(Collectors.toMap(
          Item::getId, Item::getValue,
          (OldId, newId) -> OldId, // (OldId, newId) -> newId, LinkedHashMap::new
          ));
    10. 문자열숫자 전체자리 format을 한번에 검사
        - if (!(input.chars().allMatch(Character::isDigit))) { throw new IllegalArgumentException("시도 횟수는 숫자여야 한다."); }
    11. stream()으로 `집계`와 `필터링`(max(기준) -> `해당기준(변수)의 max값으로 필터링`)
        1. int List를 포함한 `<비 int[], intStream>` -> 바로 max()안됨. 값만 구하려면 IntStream변환후 max() / 그렇지 않으면 max(기준)
            1. `바로 max()`하려면 형변환 필요 <- `바로max()를 위한 형변환 먼저는 진짜 그 값만 구하기 위할때, 원본 노상관`
                1. int List : `같은 int라도 mapToInt( x -> x) 등`의 형변환 필요, int[]아니면 바로 intStream이 안됨.
            2. **`max(기준)`으로 `기준에 해당하는 원본을 필터링 매력`**
                1. max( )인자로 들어가는 기준의 기본형태 : `Comparator.comparing  (  )`
                   **1. 원래 숫자(int list 등) 라면 : `.max(Comparator.comparing(x -> x))`**
                    - .max(Comparator.comparing(x -> x))
                      **2. 객체, 스트링 등 : `.max(Comparator.comparingInt(x -> x.getter() or Class::getter)`**
                    - .max(Comparator.comparingInt(Student::getAge))

        2. `<int[], intStream>` -> 바로 max()하여 `값만`을 return받음.
            - `바로 max()` 때린 뒤 -> Optional을 .orElse(default) or .orElseThrow(::new)
                - 참고) .orElse() 류 대신 -> `.getAsInt` 오류발생시키면서, 값이 있을 땐 int로 바로 받기
    12. 중간처리메소드 peek()로 객체생성후 log(toString) 찍어보기 : stream을 중간에 찍어보기(log), but 뒤에 메서드 나와야됌
        1. 최종처리메서드 forEach()와 같은 개념인데, 한번 중간에 돌면서 일시키는 것

        - IntStream.range(0, size)
          .mapToObj(i -> new Student("name" + i, i + 10))
          .peek(System.out::println)
          .collect((Collectors.toList()));
    13. stream으로 list를 합치는 법
        1. Stream.concat( list1.stream(), list2.stream)
            - 참고) stream으로 배열 합치는 법: Stream.of(arr1, arr2).flatMap(Stream::of).collect(Collectors.toList())
        2. stream없이 list 합치는 법
            1.     public static LottoTickets joinLottoTickets(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
        List<LottoTicket> result = new ArrayList<>(); result.addAll(manualTickets); result.addAll(autoTickets);

        return new LottoTickets(result); }

### concept(문제별 개념학습)

1. arr.clone() / Arrays.toString( arr ) 디버깅용 찍을 수있다!
    1. list도 .clone()은 있으나 Arrays 및 collections에 toString없고, 그냥 내부 오버라이딩되어있으니 sout에 찍으면 된다.
    2. 정리) arr는 바로 못찍고 `Arrays.toString( arr )` / list는 `바로찍`으니 루프 or 메서드 필요없다.
2. regex: Pattern -> Matcher -> if
   matches() : [참고](https://github.com/is2js/python_algorithm/blob/main/06_regex_practice/%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D%20%EC%97%B0%EC%8A%B5.ipynb)
    1. matcher.matches() or .find() : `t/f 반환` -> **t일때, 원하는 포맷임을 확인해주는 센스**
    2. matcher.group() : 매칭된 `값`을 반환 -> 없으면 `IllegalStateException`
        1. 내부에서 괄호치면 전체값제외 순서대로 group(1), group(2)...
    3. 자주쓰는 정규표현식

```java
    숫자만:^[0-9]*$
	영문자만:^[a-zA-Z]*$
	한글만:^[가-힣]*$
	영어&숫자만:^[a-zA-Z0-9]*$
	E-Mail:^[a-zA-Z0-9]+@[a-zA-Z0-9]+$
	휴대폰:^01(?:0|1|[6-9])-(?:\d{3}|\d{4})- \d{4}$
	일반전화:^\d{2.3}- \d{3,4}- \d{4}$
	주민등록번호: \d{6} \-[1-4]\d{6}
	IP 주소:([0-9]{1,3}) \.([0-9]{1,3}) \.([0-9]{1,3}) \.([0-9]{1,3})
	커스텀 구분자:"//;\n1;2;3"
```

3. List or Stream -> Array
    1. Stream -> Array
        1. toArray() + (Type[]::new) 생성자호출
            1. cf) **list -> stream : list.stream()**
            2. cf) array -> stream : Arrays.stream( arr ) with TypeStream
        2. **`List -> Stream -> Array`** : list -> arr배열로 갈때는 <stream안거쳐가도> `tArray()`와 `생성자`가 필요하구나.
    2. list -> array : List.toArray(new String[0])
        1. **List.stream(). +`.추가작업` + .toArray(String[]::new)**
    3. **my) list(`데이터, db`) -> stream**
        1. List<String>이면 대소문자 변환 가능 list.stream() + .map(String::toUpperCase)
        2. List<Integer>면 숫자변환 가능 list.stream() + map(x -> x*x)
        3. 중복검사 편하게 가능 .distinct().count()
    4. **my) String[] arr (`input`) -> stream**
        1. map대신 mapToInt으로 stream을 IntStream으로 변환하면서 동시에 int로 파싱 Integer::파싱 -> .map등 변환다하고나서 -> list는 Integer형이어야 하므로
           boxed
            1. Arrays.stream( arr ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())
                1. mapToInt는 `형변환 메소드 사용시 Stream도 같이 형변환` 하기 위함인듯.
    5. Integer -> stream -> Integer : 다하고 변환직전에 boxed() + toArray()시 생성자
        1. int -> stream -> int : 다하고 boxed없이, 생성자없이 .map()이후 .toArray()만
4. **Stream** -> list
    1. **stream은 한번(print)등 쓰면 다시 재활용 못한다!!**
    2. stream은 빈 스트림을 static메서드 `Stream.of( , ,)`  or `IntStream.range(a,b)`로 만듬
        1. stream -> arr by `.toArray(Type[]::new)`
            1. Int는 Integer로 바꾸기 by boxed()
        2. arr -> list by `Arrays.asList()`
            1. arr를 인자로 넣거나, `그냥 콤마만 수동으로` 넣거나
        3. stream -> list by `.collect(Collectors.toList())`
            1. cf) IntStream -> boxed()무조건해서 Stream<Integer>만들고 난뒤에야 list가능 -> List<Integer>만 가능

5. Stream으로 `list의 중복확인, 중복제거`
    1. 중복확인 -> list`.stream().distinct()` + `.count()`와 원본.size()를 비교
    2. 중복제거 -> list`.stream().distinct()` + `.collect(Collectors.toList())`로 중복제거한 리스트 뽑기
    3. HashSet, LinkedHashSet -> **인자(생성자)에 `list`만**를 받음.
        1. list급이라서 그런지 바로 출력도 된다!


6. Stream으로 배열 2개이상 합치기 > Stream.of( arr1, arr2) `.flatMap(Stream::of)` .collect(Collectors.toList());
    1. 1개의 스트림으로 만드는 마술: `.flatMap(Stream::of)`

7. 문자열의 null확인
    1. == null || .trim().isEmpty()

8. parse 2가지 방법
    1. Double.parseDouble(str);
    2. Double.valueOf(str);

9. String 역 출력 -> `new StringBuilder( string )` `.reverse()`.toString()
    1. append뿐만 아니라 reverse도 가지고 있네~
    2. split -> stream의 역순이 어렵다
        1. cf) stream().sorted()  or .sorted(Collections.reverseOrder())
    3. split -> list -> `Collections.reverse( list )`가 inplace 역순시킨다. -> stream + reduce + get으로 문자열 모으기
    4. 또는 index만 거꾸로 돌면서 , 쌩String에 바로 `.charAt(i)`

10. 객체list -> stream -> (LinkedHash)Map 만들기
    1. for문으로 돌면서 map.put( 인변.getter(), 인변2.getter())로 만들 수 도 있으나
    2. 객체list.stream()
        1. .collect( Collectors `.toMap( 객체::getter1 , 객체:getter2 )` )로 기본 Map을 만들 수 있다.
            1. 원하면 `.sorted()`로 미리 정렬해놓고 -> 나중에 LinkedHashMap설정을 해준다.
        2. toMap의 `3번째 인자`로 key중복 해결방법lambda `(old,new) -> (택1) lambda`을 설정해야 ->
        3. `4번째 인자`에서 `map종류::new`로 맵의 종류를 선택할 수 있다.
            1. LinkedHashMap을 위해, 미리 정렬해놓고 넣을 수 있는데, .collect()전에 .sorted()의 인자로
            2. `Comparator.comparing정렬기준변수타입 ( 객체:: key변수getter)` + 필요시 .reversed()로 정렬기준을 `.sorted()정렬기준을 인자`로 넣을 수 있다.

```java
Map<Integer, String> map=list.stream()
	// .sorted(Comparator.comparingInt(Item::getId).reversed())
	.collect(Collectors.toMap(
	Item::getId,
	Item::getValue,
	(OldId,newId)->OldId,
	// (OldId, newId) -> newId,
	LinkedHashMap::new
	));
```

11. 문자열 길이 확인하기 직접 변환안하고 filter, anyMatch안에서 조건식만 작성
    - Arrays.stream(stringsArray).anyMatch(s -> s.length() < 1);

12. 람다식으로 [동적코드바뀌는부분]을 채우는 [인터페이스 참조변수]자리에 들어가는 [new 구현체()]객체를 대신하여 람다식을 넣어줄 수 있다.



