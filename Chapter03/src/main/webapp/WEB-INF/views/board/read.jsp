<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<script>
      $(document).ready(function( ) {
         var operForm = $("#operForm");
         
         $("button[data-oper='modify']").on("click", function(e) {           
            operForm.attr("action","/board/modify").submit( );           
         });         
         
         $("button[data-oper='list']").on("click", function(e) {
            operForm.find("#bno").remove( );
            operForm.attr("action","/board/list")
            operForm.submit( );           
         });  
      });
   </script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title'
						value='<c:out value="${board.title }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly">
                     <c:out value="${board.content}" />
                  </textarea>
				</div>
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer }"/>' readonly="readonly">
				</div>

				<button data-oper='modify' class="btn btn-default">
					<a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a>
				</button>
				<button data-oper='list' class="btn btn-info">
					<a href="/board/list">List</a>
				</button>

				<%--
               <button data-oper='modify' class="btn btn-default">Modify</button>
               <button data-oper='list' class="btn btn-info">List</button>
--%>
				<%--
               <form id='operForm' action="/boad/modify" method="get">
                  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
               </form>
--%>
				<form id='operForm' action="/boad/modify" method="get">
					<input type='hidden' id='bno' name='bno'
						value='<c:out value="${board.bno}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'> <input
						type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
				</form>
			</div>
			<%//.panel-body-end %>
		</div>
		<%//.panel-end %>
	</div>
</div>
<%//.row-end %>

<%--
HTML 요소에 데이터(data)를 저장하고, 자바스크립트로 간단하게 데이터를 가져오면 데이터를 저장하기 위한 변수 설정이 필요없어 코드가 간결해진다.
조회된 데이터의 ajax통신과 <input>의 validation(유효성검사) 적용 등에도 활용된다.
1.데이터 저장
문법은 $(selector).data(key, value) 이다. key는 문자열형의 변수로 data가 저장될 key값이다. value는 객체형으로 JavaScript 에서 지원하는 모든 type의 데이터를 저장할수 있다.($("span").data("name", "Nextree");) 또한 HTML5에서는 HTML 요소에 data-key = 'value' 형식으로 데이터를 저장할 수 있다.(<span data-name='nextree'></span>)
2.데이터 읽기
데이터를 읽어올 때의 문법은 $('selector').data("key")이다. 키(key)는 HTML 요소의 data-key에서 사용한 key값이다. 키(key)로 값을 얻는것이다. snake-case문법(<span data-member-name="inseok"></span>)으로 저장된 데이터는 camelCase문법으로 읽어올 수 있다.($('span').data("memberName")로 "inseok"이라는 값을 얻어온다.)
3.데이터 삭제
문법은 $(selector).removeData(key)이며, key는 string type으로 삭제할 data의 key값이다.($('span').data("name"))
--%>

<%@include file="../includes/footer.jsp"%>