$(document).ready(function() {
	var SNS = {
		naver: function(url, title) {
			window.open("http://share.naver.com/web/shareView.nhn?url=" + encodeURI(encodeURIComponent("http://www.jungrangdosi.cafe24.com")) + "&title=" + encodeURI(title), "naver", "width=500, height=500");
		},
		twitter: function(url, text) {
			window.open("http://twitter.com/share?url=" + encodeURIComponent(url) + "&text=" + encodeURIComponent(text), "twitter", "width=626, height=436");
		}
	}
	$('#share-button-js').on('click', function() {
		$(this).toggleClass('active');
		
		if($(this).hasClass('active')) {
			$('#share-list-js').show();
		} else {
			$('#share-list-js').hide();
		}
	});
	
	$('#share-list-js li').on('click', function() {
		var sns = $(this).data('sns');
		var url = window.location.href;
		if(sns == 'naver') {
			SNS.naver(url, '공유 테스트');
		} else if(sns == 'facebook') {
			
		} else if(sns == 'twitter') {
			SNS.twitter(url, '');
		}
	});
});