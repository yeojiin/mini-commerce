# 🚀️ Mini Commerce

## 📌 기능 정의
1. 선착순 구매
2. 쿠폰 발급

---
## ✓ TODO

- [ ] Spring, DB 버전 정리


---

### 고려 사항

<details>
<summary>1. 선착순 구매</summary>

- 다수의 사용자가 동시에 구매 가능하다.
- <u>정해진 수량보다 판매 수량이 높을 수 없다.</u>
  + 재고 정합성 > 사용자의 구매 대기 시간
- Redis 분산락, AOP 등을 이용하여 해결?
- Redis를 클러스터 환경으로 구성하게 될 경우 failover 처리는? -> 레드락 알고리즘이 사용될 것
- 큐 등 비동기 처리는 어떻게?
  - 따닥 이슈 등은 어떻게?

</details>

<details>
<summary> 2. 쿠폰 발급 </summary>


- 서버 간 통신 시 오류가 발생할 경우 서킷브레이커를 어떻게?
  - 슬라이딩 윈도우?
    - Time-Based
    - Count-Based

</details>

<details>
<summary> 3. 재고 분리 </summary>

- Product와 ProductStock을 분리하는 게 맞을까?
  - Product 안에 stock 컬럼을 추가한다면 엔티티 구성에는 용이
  - Product와 ProductStock를 분리하게 된다면?
    - PK를 구성하는 문제 발생
    - Product 어그리게이트 안에 stock이 함께 움직임
  - 하지만 재고는 수정 빈도가 Product 정보와 다른 범위이거나 빈도가 높을 수 있음
    - 선착순 주문 시
    - 하지만 대량 주문이 몰리는 시기에 Product의 기본 정보가 변경될 확률도 적음
  - 락 충돌 방지/확장성 측면
    - 테이블을 나누면 row-level 락 범위가 줄어서 효율적
    - 향후 Redis를 이용한 재고 캐시 & 락 구현 시 깔끔한 구조로 구현 가능
 
</details>

---

### 추가 고민

**1. Predicate**

```java
@Override
public Predicate<User> chekUser(String field, String value, String operator) {
  return user -> {
    // user는 Predicate<User>.test(user)의 매개변수
    return user.getId().equals("temp");
  };
}
```

- 파라미터로 User을 받지 않아도 `람다 익명 함수로` user를 사용할 수 있음
- Predicate<T>의 boolean test(T t);를 checkUser()로 구현된 것

```java
@Override
public Predicate<User> chekUser(String field, String value, String operator) {
  return new Predicate<User>() {
    @Override
    public boolean test(User user) {
      return user.getId().equals("temp");
    }
  };
}
```
> - 람다는 Predicate<User>의 test(T t) 메서드를 구현하는 익명클래스의 인스턴스를 반환한다.
> - checkUser()가 람다식을 통해 반환한 객체가 `Predicate<User>`의 구현체이다.
> - 즉, checkUser()는 람다식을 리턴하므로, Predicate<User> 구현체를 리턴하는 메서드이다.