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
        4. 

