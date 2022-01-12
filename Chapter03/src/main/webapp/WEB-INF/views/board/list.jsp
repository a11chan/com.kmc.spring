<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<script>
	$(document).ready(function(){
		$('#regBtn').on("click",function(){
			self.location = "/board/register";
		});
		
		var result = '<c:out value="${result}"/>';
		checkModal(result);
		history.replaceState({},null,null);
		
		function checkModal(result) {
			if(result===''||history.state) return;
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 "+parseInt(result)+
						"번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
	});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				Board List Page
				<button id="regBtn" type="button"
					class="btn btn-xs btn-primary pull-right">Register</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<%--BoardController에서 Model객체를 이용하여 모든 게시물을
								list라는 이름으로 담아서 전달했으므로 list.jsp에서 ${list}로
								모든 게시물을 받은 후 for문을 사용하여 게시물 각각을 board에
								받아 출력한다.
								 --%>

					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a
									href='/board/read?bno=
											<c:out value="${board.bno}"/>'>
										<c:out value="${board.title}" />
								</a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->

			<!-- modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<!-- <button type="button" class="btn btn-primary">Save
								changes</button> -->
						</div>
					</div>
					<% //.modal-content-end %>
				</div>
				<% //.modal-dialog-end %>
			</div>
			<% //.modal-end %>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<%@ include file="../includes/footer.jsp"%>