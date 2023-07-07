## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [ ] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [ ] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지에서 접근 URL 은 http://주소:포트/article/list 이다.
- [ ] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [ ] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

## 미비사항 or 막힌 부분
- ...

## MVC 패턴
- model : 데이터와 관련된 부분
- view : 사용자한테 보여지는 부분
- controller : model과 view를 이어주는 부분
- model은 controller와 view에 의지하지 않는다.
- view는 model에 의존하고, controller에 의존x, model에 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받는다.
- controller는 model,view 의존한다. view가 model로부터 데이터를 받을 때, 반드시 controller에서 받아야한다.

## 스프링에서 의존성 주입(DI) 방법
- 생성자 주입
- 수정자 주입(Setter 주입)
- 필드 주입
- 일반 매서드 주입