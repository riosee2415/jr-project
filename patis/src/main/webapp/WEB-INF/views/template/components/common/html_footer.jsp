<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <form method="get" id="frm-link"></form>
    <form action="/fileDownload.do" method="post" id="frm-download">
    	<input type="hidden" name="filePath" />
    	<input type="hidden" name="fileName" />
    </form>
	</body>
	
	<script src="/assets/plugins/daum-editor/js/editor_loader.js"></script>
	<script src="/assets/js/jquery-1.12.4.min.js"></script>
	<script src="/assets/js/daum_editor.js"></script>
	<script src="/assets/js/init.js"></script>
	<script src="/assets/js/common.js"></script>
	<script src="/assets/js/main.js"></script>
	<script src="/assets/js/header.js"></script>
	<script src="/assets/js/footer.js"></script>
	<script src="/assets/js/sub_banner.js"></script>
	<script src="/assets/js/sub_top_menu.js"></script>
	<script src="/assets/js/board.js"></script>
	<script src="/assets/js/sns_share.js"></script>
	<script src="/assets/js/NM000000.js"></script>
	<script src="/assets/js/NM020523.js"></script>
	
	<script>
		var msg = '${msg}';
		if(!isEmpty(msg)) {
			alert(msg);
		}
	</script>
</html>
