# 🛍️RestockNotifyer
 - 쇼핑몰 상품 재입고 알리미

## 개발 배경
 - 쇼핑몰 자체 재입고 알림 서비스 이용시 알림이 입고와 동시에 이루어지지 않음
 - 재입고 후 정해진 시간에 먼저 신청한 사람부터 순차적으로 알림이 발송됩
 - 재입고 후 알림 발송 전에 상품 확인시 바로 구매 가능
 - 인기 상품의 경우 알림을 받았을 때 이미 품절되었을 가능성이 높음
 - 쇼핑몰 자체 재입고 알림 서비스 신청시 품목 수 제한이 있는 경우가 있음
 * 재입고 즉시 실시간 알림은 어려우므로 설정한 시간마다 상품을 확인하여 재입고 여부를 알려주는 것이 필요하다 생각함

### 📚개발중
 - Notification을 사용하여 웹 페이지를 켜놓으면 저장한 상품의 재고를 판단해 재고가 존재하면 알림 발생
 - 일정 시간마다 재고를 반복해서 확인

# ️💻개발 환경
 - 사용언어: Java/JSP, SQL, HTML5/CSS3/JavaScript(Bootstrap4)
 - 운영체제: Windows 10 x64, AWS EC2 Linux
 - 개발도구: Eclipse IDE, PuTTY
 - DB: MariaDB 
