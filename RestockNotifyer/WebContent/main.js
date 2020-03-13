var timer = 10 * 1000;

function load() {
	
	var urlInput = $('#url-input');
	Notification.requestPermission(function(result) {

		// 요청 거절
		if (result === 'denied') {
			// 입력폼 비활성화
			urlInput.attr('disabled');

			return;
		}
		// 요청 허용
		else {
			// 입력폼 활성화
			urlInput.removeAttr('disabled');

			return;
		}
	});

};

function notificationOpen(prdName, prdUrl, prdImg) {

	var options = {
		body : prdName,
		timestamp : Date,
		requireInteraction : true,
		icon : prdImg
	}

	// 데스크탑 알림 요청
	var notification = new Notification('입고 알림', options);

	notification.onclick = function() {
		window.open(prdUrl, '_blank');
	}
	setTimeout(notification.close.bind(notification), timer - 1000);
};

function refreshListTable() {
	
	var table = $('#list-table');
	location.reload();
}
