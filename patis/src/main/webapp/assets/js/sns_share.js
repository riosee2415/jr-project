$(document).ready(function() {
	var SNS = {
		naver: function(url, title) {
			window.open("http://share.naver.com/web/shareView.nhn?url=" + encodeURI(encodeURIComponent(url)) + "&title=" + encodeURI(title), "naver", "width=630, height=650");
		},
		facebook: function(url, title) {
			window.open("http://www.facebook.com/share.php?u=" + encodeURIComponent(url) + "&t=" + encodeURIComponent(title), "facebook", "width=500, height=500")
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
			SNS.naver(url, '제목');
		} else if(sns == 'facebook') {
			SNS.facebook(url, '')
		} else if(sns == 'twitter') {
			SNS.twitter(url, '');
		}
	});
});