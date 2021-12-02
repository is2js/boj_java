### concept

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

9. String 역 출력 -> new StringBuilder( string ) `.reverse()`.toString()
    1. split -> stream은 역순이 어렵다
       1. cf) stream().sorted()  or .sorted(Collections.reverseOrder())
    2. split -> list -> `Collections.reverse( list )`가 inplace 역순시킨다. -> stream + reduce + get으로 문자열 모으기
    3. 또는 index만 거꾸로 돌면서 , 쌩String에 바로 `.charAt(i)`

### stream 모음

1. list 중복확인 -> list`.stream().distinct()` + `.count()`와 원본.size()를 비교
2. list **중복제거** -> list`.stream().distinct()` + `.collect(Collectors.toList())`로 중복제거한 리스트 뽑기
3. arr 합치기 -> Stream.of( arr1, arr2) `.flatMap(Stream::of)` .collect(Collectors.toList());ㄴ
4. 문자열array -> List<Integer> 형변환 -> Arrays.stream( arr )`.mapToInt(Integer::parseInt).boxed()`.collect(
   Collectors.toList())
5. 문자 대소문자 전환 ->  List<String>이면 대소문자 변환 가능 list.stream() + `.map(String::toUpperCase)`
6. 숫자 값 변경 -> List<Integer>면 숫자변환 가능 list.stream() + `map(x -> x*x)`

7. 고난도
    1. list -> 문자열 합치기: hashSet.stream()`.map(Object::toString).reduce((a,b)->a+b).get()`;
    2. 원소Class가 가진 isXXX, hasXXX메서드를 통해, 해당하는 것 있는지 검색할 때
        - return this.result.stream()`.anyMatch(Scores::hasStrike)`;
        - return this.scores.stream().anyMatch(Score::isStrike);
        - return this == STRIKE;
    3. Enum 속 finder로 분기별 처리되도록 검색할 때
        - return Arrays.stream( OperateType.values())
          .filter( e -> e.symbol.equals( symbol ))
          .findAny()
          .orElseThrow( () -> new IllegalArgumentException("not a arithmetic symbols"));
    4. list의 집계함수 만들기
        - list의 집계를 reduce().get() + Integer::sum 으로 구하기 return list.stream()
          .reduce(Integer::sum)
          .get();
    5. enum finder 속 filter에 들어갈 또다른 람다식으로 boolean식 만들기
        - Arrays.stream(Program.values())
          .filter(e -> e.list.stream().anyMatch(element -> element.equals(name)))
          .filter(hasNameInGroup(name))
          .findAny()
          .orElseThrow(() -> new IllegalArgumentException("없는 프로그램입니다."));
