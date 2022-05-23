Merhabalar,

_Not: Case çalışmasında belirttiğiniz 'Selendroid Test App' uygulamasının apk dosyasını şirket bilgisayarım da ki Android 
Studio üzerinde çalışan sanal android cihaza yetki sorunu sebebi ile deploy edemediğim için bahsettiğiniz herhangi
4 testi Selendroid uygulamasının muadli olan ve apk'sı `src/main/resources/apk/ApiDemos-debug.apk` dizininde yer alan ApiDemos isimli farklı 
bir uygulama için yazdım._

**Case'leri yazarken yazdığım case'in içeriğinden ziyade uygulamanın mimarisine vakit ayırdım. Projeyi detaylı 
incelediğiniz taktirde çok kolaylıkla farklı platformlara (web, api vs) genişletilebilir olduğunu görebilirsiniz.**

_Test'leri koşmadan önce andoid studio içerisinden ayağa kaldırdığınız andoid cihazı `Emulator` diye isimlendirmenizi rica ederim._

Case'lere `src/test/java/mobile/ApiDemoTest` class'ından erişebilirsiniz.

Yazdığım 4 adet case'in stepleri aşağıdaki gibidir;

Case1 - Csv'de yer alan test data'sına göre saat dakikası ayarlama testi
 - Uygulama içerisinde yer alan sırası ile aşağıdaki elementler tablanır.
   `Views -> Date Widgets -> Inline`
 - Açılan sayfada yer alan saatin akrebi'nin aşağıda path'i verilen csv dosyasında yer alan data'ya göre swipe edildiği
   görülür.
   `src/main/resources/testdata/swipe-minute-hand-to-list.csv`
   
Case2 - Sürükle bırak testi
 - Uygulama içerisinde yer alan sırası ile aşağıdaki elementler tablanır.
  `Views -> Drag and Drop`
 - Açılan sayfada yer alan toplardan ilki hemen sağında yer alan ikincisinin üzerine sürüklendiği görülür.

Case3 - Popup bilgileri doldurulur.
 - Uygulama içerisinde yer alan sırası ile aşağıdaki elementler tablanır.
  `Preference -> Preference dependencies`
 - Açılan sayfada yer alan `WiFi` selectbox'ı set'lenir.
 - WiFi select box'ının setlenmesi ile aktifleşen `WiFi Settings` elemenri tablanir.
 - Açılan popup'da yer alan text box'a `Test Automation` yazılır ve `OK` butonu tıklanır.
 - Ardından popup tekrar açıldığında bir önceki adımda kaydedilen `Test Automation` yazısının set'li geldiği görülür.

Case4 - Basılı tutma testi:
 - Uygulama içerisinde yer alan sırası ile aşağıdaki elementler tablanır.
   `Views -> Expandable List -> 1. Custom Adapter`
 - Açılan sayfada `People Names` elementinin üzerine basılı tutulur.
 - Açılan popup'da `Sample menu` textinin geldiği görülür.




Projede yer alan tüm testleri komut satırı üzerinden maven surefire plugin'i ile koşmak için POM.xml'in olduğu dizinde
`mvn clean verify` komutu verilir.

Özel bir test suit oluşturmak için ise Pom.xml de profil hazırlanır ve içerisine istenilen case'ler eklenilip, 
istenilmeyenler çıkartıldıkdan sonra aşağıdaki maven komutu ile ilgili suit içerisinde yer alan testler execute edilir.
`mvn clean verify -PprofilName`

Testler'den birinin fail olması durumunda 'src/main/java/base/BaseTest' içerisinde yer alan test rule implementasyon'u 
olan TestWatcherItems içerisinde yer alan fail hook'u içerisinde ekran görüntüsü alınıp 'screenshots' dizini içerisine 
kaydedilmektedir.

Testleri koşan Surefire plugin'inin Allure property'si test sonuçlarını 'allure-results' içerisine log'lamaktadır. 
Bu log file'lardan test raporu oluşturmak için ilgili dizinde allure `serve allure-results` komutu çalıştırılır. 
Bu komutu çalıştırabilrmek için allure bilgisayarımızda kurulu olmalıdır.(`brew install allure`)

