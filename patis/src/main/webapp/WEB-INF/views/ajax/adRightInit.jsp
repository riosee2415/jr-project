<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="" method="get">
	<div class="right__content__block">
	
		<span>읽기 권한</span> 
		<select id="right-read" name="right-read">
			<c:forEach var="data" items="${RightList }">
				<option value="${data.DETAIL_CODE }">${data.VAL }</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="right__content__block">
		<span>쓰기 권한</span> 
		<select id="right-write" name="right-read">
			<c:forEach var="data" items="${RightList }">
				<option value="${data.DETAIL_CODE }">${data.VAL }</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="right__content__block">
		<input type="submit" value="권한변경" />
	</div>
</form>


<script>
	$(document).ready(function(){
		getCurrentRight();
	})
	
	
	function getCurrentRight(){

		var mc = numberFormat($('#ad02-table').data('mc'), 2);
		var sc = numberFormat($('#ad02-table').data('sc'), 2);
		
		var adCode = mc + sc;

		
		 $.ajax({
			    url: "/ad" + adCode + "CurrentRight.do",
			    type: "get",
			    data: {
			      
			    },
			    success: function(data) {
				    var view = $.trim(data.split("-----")[0]);
				    var write = $.trim(data.split("-----")[1]);


					$("#right-read").val(view);    		    
					$("#right-write").val(write);    		    

			    }
			  });
	}


</script>