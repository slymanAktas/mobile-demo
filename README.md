Merhabalar,

_Not: Case çalışmasında belirttiğiniz 'Selendroid Test App' uygulamasının apk dosyasını şirket bilgisayarım da ki Android 
Studio üzerinde çalışan sanal android cihaza yetki sorunu sebebi ile deploy edemediğim için bahsettiğiniz herhangi
4 testi Selendroid uygulamasının muadli olan ve apk'sı `src/main/resources/apk/ApiDemos-debug.apk` dizininde yer alan ApiDemos isimli farklı 
bir uygulama için yazdım._

Case'lere `src/test/java/mobile/ApiDemoTest` class'ından erişebilirsiniz.

**Case'leri yazarken yazdığım case'in içeriğinden ziyade uygulamanın mimarisine vakit ayırdım. Projeyi detaylı 
incelediğiniz taktirde çok kolaylıkla farklı platformlara (web, api vs) genişletilebilir olduğunu görebilirsiniz.**

_Test'leri koşmadan önce andoid studio içerisinden ayağa kaldırdığınız andoid cihazı `Emulator` diye isimlendirmenizi rica ederim._

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
