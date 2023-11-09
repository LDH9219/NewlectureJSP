# NewlectureJSP
이 레포지토리는 ```2022/11/4 ~ 12/23``` 까지 <a href ="https://www.youtube.com/watch?v=drCj2k50j_k&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd"> Newlecture강의</a> 를 보고 실습한 파일을 올린 레포지토리이다.    

클론코딩을 하면서 정리한 파일들은 <a href = "https://github.com/LDH9219/JSP_servlet">이곳</a>에 보관중이다.

본 README에서는 아래와 같은 목차를 다룬다.

### 목차
> * 1.구현 목표    
> * 2.작동원리 및 순서    
> * 3.어려웠던 점 & 개선 및 보완 , 추가적 공부가 필요한 점  
> * 4.해결방법
    
## 1. 구현목표
공지사항 페이지를 구성하는 요소들을 구현하고, 공지사항 세부페이지의 내용들을 구현한다.
페이지의 구성 요소는 아래와 같다.

### 사용자 기준
> * 공지사항
> > * 공지사항 목록 불러오기
> > > * 공지사항 목록 뒤 [n] 댓글 카운팅 첨부
> > * 페이지 요청    
> > > * 이전, 다음페이지
> > > * 원하는 페이지 값 요청하기
> > * 검색 요청    
> > > * 제목검색
> > > * 작성자검색
> > * 페이지 수 카운팅
> * 공지사항 세부 페이지
> > * 공지사항의 정보 불러오기
> > * 페이지 이동
> > > * 목록 이동
> > > * 다음 글 이동
> > > * 이전 글 이동

### 관리자 기준
> * 공지사항
> > * 공지사항 작성
> > * 공지사항 일괄공개
> > * 공지사항 일괄삭제

## 2. 작동원리
![image](https://user-images.githubusercontent.com/62749021/209472574-91a92c66-3b10-434b-9b03-5c52d62f59ba.png)

본 JSP 실습은 MVC 모델2 를 지향하여 진행되었으며, View와 Controller를 분리하여 소스코드의 가시성을 높이고 유지보수를 효율적으로 하기 위함이다.
사용된 파일은 아래와 같다.   

패키지 = <a href = "https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/java/com/newlecture/web/controller/admin/notice">
com.newlecture.web.controller.admin.notice
</a>
<br>
<a href = "https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/controller/admin/notice/DetailController.java">
  DetailController.java
</a> - 관리자용 세부 페이지 컨트롤러
<br>
<a href = "https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/controller/admin/notice/ListController.java">
  ListController.java
</a> - 관리자용 공지사항 목록 컨트롤러
<br>
<a href = "https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/controller/admin/notice/RegController.java">
  RegController.java
</a> - 관리자용 공지사항 등록 컨트롤러    

패키지 = <a href="https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/java/com/newlecture/web/controller/notice">
com.newlecture.web.controller.notice
</a>
<br>
<a href = "https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/controller/notice/DetailController.java">
DetailController.java
</a> - 사용자용 세부 페이지 컨트롤러
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/controller/notice/ListController.java">
ListController.java
</a> - 사용자용 공지사항 목록 컨트롤러
<br>

패키지 = <a href ="https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/java/com/newlecture/web/entity">
  com.newlecture.web.entity
</a>
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/entity/Notice.java">
Notice.java
</a> - 공지사항에 필요한 객체들 파일
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/entity/NoticeView.java">
NoticeView.java
</a> - 공지사항 목록용 댓글 카운팅
<br>

패키지 = <a href ="https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/java/com/newlecture/web/service">
com.newlecture.web.service
</a>
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/java/com/newlecture/web/service/NoticeService.java">
NoticeService.java
</a> - 공지사항 페이지에 필요한 기능들
<br>

관리자용 디렉토리 = <a href = "https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/webapp/WEB-INF/view/admin/board/notice">
src/main/webapp/WEB-INF/view/admin/board/notice
</a>
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/webapp/WEB-INF/view/admin/board/notice/detail.jsp">
detail.jsp
</a> - 보여지는 관리자용 세부 페이지 jsp
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/webapp/WEB-INF/view/admin/board/notice/list.jsp">
list.jsp
</a> - 보여지는 관리자용 공지사항 목록 jsp
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/webapp/WEB-INF/view/admin/board/notice/reg.jsp">
reg.jsp
</a> - 보여지는 관리자용 공지사항 등록 jsp

사용자용 디렉토리 = <a href = "https://github.com/LDH9219/NewrectureJSP/tree/main/JSPPrj/src/main/webapp/WEB-INF/view/notice">
src/main/webapp/WEB-INF/view/notice
</a>
<br>
<a href ="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/webapp/WEB-INF/view/notice/detail.jsp">
detail.jsp
</a> - 보여지는 사용자용 세부 페이지 jsp
<br>
<a href="https://github.com/LDH9219/NewrectureJSP/blob/main/JSPPrj/src/main/webapp/WEB-INF/view/notice/list.jsp">
list.jsp
</a> - 보여지는 사용자용 공지사항 목록 jsp
<br>

***

본 실습 예제는 <br>
보여지는 각 ```페이지 별 JSP```<br>
기능을 담당하는 ```NoticeSerive.java``` 기능파일<br>
각 ```페이지 JSP```에 대응하는 ```Controller```와<br>
페이지 및 기능에 필요한 객체를 담고 있는 ```Notice.java```파일로 이루어져 있다.<br>


## 3. 어려웠던 점 & 개선 및 보완 , 추가적 공부가 필요한 점
View와 Controller의 흐름을 파악하는 것은 코딩을 직접 하면서 익힐 수 있었으나    
객체를 통해 정보를 전달할 때 사용하는 클래스(ex: StringBuilder) 및 List와 같은 컬렉션에 대한 추가적인 공부를 요한다.
현재의 수준으로는 ```how``` 어떻게 작동하는지는 확인하였지만
다른 방법은 없는지, 저것이 제일 효율적인지, 왜 저것을 사용하는지에 대한 ```WHY```는 확인이 불가능하다.

## 4. 해결방법
각 메서드 별 기능을 추출하여 정리하고, 메서드의 입력값과 절차 및 반환값을 확인을 요한다.
