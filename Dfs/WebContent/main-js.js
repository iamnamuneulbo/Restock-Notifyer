var notificationButton = $("#notificationButton");
var notificationMessage = $("#notificationMessage");
// 데스크탑 알림 권한 요청
function load() {
	Notification.requestPermission(function(result) {
		// 요청을 거절하면,
		if (result === 'denied') {
			// console.log("거절");
			return;
		}
		// 요청을 허용하면,
		else {
			// 데스크탑 메시지 입력폼을 활성화
			notificationMessage.removeAttr('disabled');
			// 데스크탑 메시지 요청 버튼을 활성화
			notificationButton.removeAttr('disabled');
			return;
		}
	});
};

// 데스크탑 알림 버튼을 누르면,
function notificationOpen(prdName, prdUrl) {
	var options = {
		body : prdName,
		timestamp: Date,
		requireInteraction: true
	// icon : iconDataURI
	}
	// 데스크탑 알림 요청
	var notification = new Notification("면세점 입고 알림", options);

	notification.onclick = function() {
		window.open(prdUrl, '_blank');
	}
}


// 데스크탑 알림 버튼을 누르면,
notificationButton.on("click", function() {
	var message = notificationMessage.val();

	// 메시지를 입력한 경우에만,
	// if (message !== null && message.length > 0) {
	var options = {
		body : message,
	// icon : iconDataURI
	}

	// 데스크탑 알림 요청
	var notification = new Notification("면세점 입고 알림", options);

	// 알림 후 5초 뒤,
	// setTimeout(function() {
	// 얼람 메시지 닫기
	// notification.close();
	// }, 5000);
	// }
});